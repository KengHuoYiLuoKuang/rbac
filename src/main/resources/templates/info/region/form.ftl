<form class="app-form" id="region-form">
  <input type="hidden" name="id">
  <div class="field">
    <input class="easyui-textbox" name="regionCode" style="width:80%" data-options="label:'区县编号：',required:true">
  </div>
    <div class="field">
        <input class="easyui-textbox" name="region" style="width:80%" data-options="label:'区县名称：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="cityCode" style="width:80%" data-options="label:'所属市区：',required:true">
    </div>
</form>
<script>
	<#if region??>
    $(function () {
      //需要延迟一点执行，等待页面所有组件都初始化好，再执行数据初始化
      setTimeout(function () {
        var region = ${region};
        if (region.roles) {
          var roles = [];
          $.each(region.roles, function () {
            roles.push(this.id);
          });
          member.roles = roles.join(",");
        }
        $("#region-form").form("load", region);
      }, 200);
    });
	</#if>
</script>