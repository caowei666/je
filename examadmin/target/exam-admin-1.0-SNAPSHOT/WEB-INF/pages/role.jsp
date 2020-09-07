<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%> /media/jquery.easyui.min.js"></script>
<link href="<%=request.getContextPath()%> /media/easyui.css" rel="stylesheet">
<%--<div class="layui-form-item">--%>
    <%--<form class="layui-form" method="post">--%>
        <%--<div class="layui-inline">--%>
            <%--<label class="layui-form-label">账号</label>--%>
            <%--<div class="layui-input-inline">--%>
                <%--<input type="text" name="account" autocomplete="off" class="layui-input">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="layui-inline">--%>
            <%--<label class="layui-form-label">昵称</label>--%>
            <%--<div class="layui-input-inline">--%>
                <%--<input type="text" name="nickname" autocomplete="off" class="layui-input">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="layui-inline">--%>
            <%--<button class="layui-btn" lay-submit lay-filter="searchForm">查询</button>--%>
        <%--</div>--%>
    <%--</form>--%>
<%--</div>--%>
<table id="roleTable" lay-filter="test"></table>
<script type="text/html" id="headTool">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
    </div>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="assign">授权</a>
</script>
<script>
    layui.use(['table', 'form'], function () {
        var table = layui.table;
        var form = layui.form;
        //第一个实例
        table.render({
            id: 'userTable',
            elem: '#roleTable'
            , toolbar: '#headTool'
            , height: 312
            , url: '<%=request.getContextPath()%>/sys/role.html?act=table' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'ID'}
                , {field: 'name', title: '角色'}
                , {field: 'remark', title: '备注'}
                , {field: 'status', title: '状态'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
        });
        form.on('submit(searchForm)', function (data) {
            console.log(data)
            table.reload('userTable', {
                where: data.field
            });
            return false;
        })
        function openEditLayer(data) {
            layer.open({
                type: 1,
                content: $("#tree").html() //这里content是一个普通的String
                , btn: ['提交', '取消']
                , yes: function (index, layero) {
                    var nodes = $('#tt').tree('getChecked', ['checked','indeterminate']);
                    var ids = new Array();
                    for(var i = 0;i<nodes.length;i++){
                        ids.push(nodes[i].id);
                    }
                    console.log(ids);
                    $.ajax({
                        url: "<%=request.getContextPath()%>/sys/role.html?act=assign",
                        method: "post",
                        data: "menuIds="+ids+"&roleId="+data,
                        success: function (res) {
                            if (res.status) {
                                layer.close(index);
                            } else {
                                layer.msg(res.message);
                            }
                        }
                    })
                }
                , btn2: function (index, layero) {
                    layer.close(index);
                }
                , success: function (layero, index) {
                    $.ajax({
                        url: "<%=request.getContextPath()%>/sys/role.html?act=menu",
                        data: "roleId="+data,
                        success: function (res) {
                            $('#tt').tree({
                                url: "<%=request.getContextPath()%>/sys/menu.html?act=tree&needButton=true",
                                checkbox:true,
                                onLoadSuccess:function(node,data){
                                    $.each(res,function (i, obj) {
                                        var node = $('#tt').tree('find', obj);
                                        if(node!=null && $('#tt').tree('isLeaf',node.target)){
                                            $('#tt').tree('check', node.target);
                                        }
                                    })
                                }
                            })
                        }
                    })
                }
            });
        }
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'assign'){
                openEditLayer(data.id);
            }
        });
        table.on('toolbar(test)', function (obj) {
            console.log(obj);
            var checkStatus = table.checkStatus(obj.config.id);
            var data = checkStatus.data;
            switch (obj.event) {
                case 'add':
                    openEditLayer(data);
                    break;
                case 'delete':
                    if (data.length < 1) {
                        return
                    } else {
                        var ids = new Array();
                        for (var i = 0; i < data.length; i++) {
                            ids.push(data[i].id);
                        }
                        $.ajax({
                            url: "<%=request.getContextPath()%>/sys/user.html?act=delete",
                            method: "post",
                            data: "ids=" + ids,
                            success: function (res) {
                                if (res.status) {
                                    table.reload("userTable", {})
                                } else {
                                    layer.msg(res.message);
                                }
                            }
                        })
                    }
                    break;
                case 'update':
                    if (data.length != 1) {
                        layer.msg("只能选择一行")
                        return
                    } else {
                        openEditLayer(data);
                    }
                    break;
            }
            ;
        });
    });
</script>
<script type="text/html" id="tree">
    <ul id="tt" class="easyui-tree"></ul>
</script>
<script type="text/html" id="editFormLayer">
    <form class="layui-form" action="" id="editForm" lay-filter="editForm">
        <input type="hidden" name="id">
        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline">
                <input type="text" name="account" readonly required lay-verify="required" placeholder="请输入账号"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" placeholder="请输入密码"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="nickname" required lay-verify="required" placeholder="请输入昵称"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline">
                <input type="radio" name="status" value="1" title="有效">
                <input type="radio" name="status" value="0" title="无效">
            </div>
        </div>
    </form>
</script>
