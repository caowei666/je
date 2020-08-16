<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="media/jquery.easyui.min.js"></script>
<link href="media/easyui.css" rel="stylesheet">
<button class="layui-btn layui-btn-sm" id="addBtn">添加</button>
<button class="layui-btn layui-btn-sm">删除</button>
<ul id="tt" class="easyui-tree"></ul>


<script>
    layui.use(['form'], function () {
        var form = layui.form;
        $('#tt').tree({
            url: "/sys/menu.html?act=tree&needButton=true"
        })

        $("#addBtn").click(function () {
            openEditLayer(null);
        })

        function openEditLayer(data) {
            layer.open({
                type: 1,
                zIndex:10000,
                content: $("#editFormLayer").html() //这里content是一个普通的String
                , btn: ['提交', '取消']
                , yes: function (index, layero) {
                    var data1 = $("#editForm").serialize();
                    $.ajax({
                        url: "/sys/user.html?act=edit",
                        method: "post",
                        data: $("#editForm").serialize(),
                        success: function (res) {
                            if (res.status) {
                                table.reload("userTable", {})
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
                    if (data != null) {
                        form.val("editForm", data);
                        form.val("editForm", {type: data.type + ''});
                    }
                    form.render();
                    $('#parentId').combotree({
                        url: '/sys/menu.html?act=tree&needButton=false',
                        required: true
                    });
                }
            });
        }
    })
</script>

<script type="text/html" id="editFormLayer">
    <form class="layui-form" action="" id="editForm" lay-filter="editForm">
        <input type="hidden" name="id">
        <div class="layui-form-item">
            <label class="layui-form-label">菜单名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" readonly required lay-verify="required" placeholder="请输入菜单名"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">父节点</label>
            <div class="layui-input-inline">
                <input type="password" name="parentId" id="parentId">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">url</label>
            <div class="layui-input-inline">
                <input type="text" name="url" required lay-verify="required" placeholder="请输入url"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="radio" name="type" checked value="0" title="目录">
                <input type="radio" name="type" value="1" title="连接">
                <input type="radio" name="type" value="2" title="按钮">
            </div>
        </div>
    </form>
</script>