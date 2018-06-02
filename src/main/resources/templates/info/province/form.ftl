<form class="app-form" id="province-form">
  <input type="hidden" name="id">
  <div class="field">
    <input class="easyui-textbox" name="provinceCode" style="width:80%" data-options="label:'省份编号：',required:true">
  </div>
    <div class="field">
        <input class="easyui-textbox" name="province" style="width:80%" data-options="label:'省份名称：',required:true">
    </div>
</form>
<script>
	<#if province??>
    $(function () {
      //需要延迟一点执行，等待页面所有组件都初始化好，再执行数据初始化
      setTimeout(function () {
        var province = ${province};
        if (province.roles) {
          var roles = [];
          $.each(province.roles, function () {
            roles.push(this.id);
          });
          member.roles = roles.join(",");
        }
        $("#province-form").form("load", province);
      }, 200);
    });
	</#if>
</script>