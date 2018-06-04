<form class="app-form" id="nation-form">
  <div class="field">
    <input class="easyui-textbox" name="nationCode" style="width:80%" data-options="label:'省份编号：',required:true">
  </div>
    <div class="field">
        <input class="easyui-textbox" name="nation" style="width:80%" data-options="label:'省份名称：',required:true">
    </div>
</form>
<script>
	<#if nation??>
    $(function () {
      //需要延迟一点执行，等待页面所有组件都初始化好，再执行数据初始化
      setTimeout(function () {
        var nation = ${nation};
        if (nation.roles) {
          var roles = [];
          $.each(nation.roles, function () {
            roles.push(this.id);
          });
          member.roles = roles.join(",");
        }
        $("#nation-form").form("load", nation);
      }, 200);
    });
	</#if>
</script>