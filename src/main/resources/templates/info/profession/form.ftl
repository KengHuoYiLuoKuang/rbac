<form class="app-form" id="profession-form">
  <input type="hidden" name="id">
  <div class="field">
    <input class="easyui-textbox" name="professionCode" style="width:80%" data-options="label:'职业编号：',required:true">
  </div>
    <div class="field">
        <input class="easyui-textbox" name="profession" style="width:80%" data-options="label:'职业名称：',required:true">
    </div>
</form>
<script>
	<#if profession??>
    $(function () {
      //需要延迟一点执行，等待页面所有组件都初始化好，再执行数据初始化
      setTimeout(function () {
        var profession = ${profession};
        if (profession.roles) {
          var roles = [];
          $.each(profession.roles, function () {
            roles.push(this.id);
          });
          member.roles = roles.join(",");
        }
        $("#profession-form").form("load", profession);
      }, 200);
    });
	</#if>
</script>