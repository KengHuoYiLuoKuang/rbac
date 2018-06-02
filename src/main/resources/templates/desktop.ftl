<div class="easyui-panel"  title="人口登记校验" style="width:480px">
<form class="app-form" id="population-form">
    <div class="field">
        <input class="easyui-textbox" name="realName" style="width:80%" data-options="label:'姓名：',required:true">
        <select class="easyui-combobox" editable="false" data-options="panelHeight:'auto'" name="gender" style="width:18%">
            <option value="BOY">男</option>
            <option value="GIRL">女</option>
        </select>
    </div>

    <div class="field">
        <input class="easyui-textbox" name="idCardNumber" style="width:100%" data-options="label:'身份证：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="age" style="width:100%" data-options="label:'年龄：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="telephone" style="width:100%" data-options="label:'电话：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="nation" style="width:100%" data-options="label:'民族：',required:true">
    </div>

    <div class="field">
        <input class="easyui-combobox" name="province" style="width:100%" data-options="label:'所在省份：',required:true">
    </div>
    <div class="field">
    <input class="easyui-combobox" name="city" style="width:100%" data-options="label:'市区：',required:true">
    </div>
    <div class="field">
    <input class="easyui-combobox" name="village" style="width:100%" data-options="label:'区县：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="profession" style="width:100%" data-options="label:'职业：',required:true">
    </div>

    <input class="easyui-datebox" name="birthDate" style="width:100%" data-options="label:'出生年月：',editable:false">

    <div class="field">
        <label class="textbox-label textbox-label-before">城镇户口：</label>
        <input class="easyui-switchbutton" name="urban" data-options="onText:'是',offText:'否',checked:true" value="true">
    </div>
    <div class="field">
        <label class="textbox-label textbox-label-before">流动人口：</label>
        <input class="easyui-switchbutton" name="urban" data-options="onText:'是',offText:'否',checked:true" value="true">
    </div>
</form>
</div>
<script>
  <#if member??>
    $(function () {
        //需要延迟一点执行，等待页面所有组件都初始化好，再执行数据初始化
        setTimeout(function () {
            var member = ${member};
            if (member.roles) {
                var roles = [];
                $.each(member.roles, function () {
                    roles.push(this.id);
                });
                member.roles = roles.join(",");
            }
            $("#member-form").form("load", member);
        }, 200);
    });
  </#if>
</script>