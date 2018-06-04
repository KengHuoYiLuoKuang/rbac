<form class="app-form" id="people-form">
  <input type="hidden" name="id">
    <div class="field">
        <input class="easyui-textbox" name="" style="width:80%" data-options="label:'姓名：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="gender" style="width:80%" data-options="label:'性别：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="idNumber" style="width:80%" data-options="label:'身份证：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="profession" style="width:80%" data-options="label:'出生日期：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="nation" style="width:80%" data-options="label:'年龄：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="nation" style="width:80%" data-options="label:'电话：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="nation" style="width:80%" data-options="label:'所在省份：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="nation" style="width:80%" data-options="label:'市区：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="nation" style="width:80%" data-options="label:'区县：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="nation" style="width:80%" data-options="label:'职业：',required:true">
    </div>
</form>
<script>
	<#if people??>
    $(function () {
      //需要延迟一点执行，等待页面所有组件都初始化好，再执行数据初始化
      setTimeout(function () {
        var people = ${people};
        if (people.roles) {
          var roles = [];
          $.each(people.roles, function () {
            roles.push(this.id);
          });
          member.roles = roles.join(",");
        }
        $("#people-form").form("load", people);
      }, 200);
    });
	</#if>
</script>