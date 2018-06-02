<form class="app-form" id="city-form">
  <input type="hidden" name="id">
  <div class="field">
    <input class="easyui-textbox" name="cityCode" style="width:80%" data-options="label:'市区编号：',required:true">
  </div>
    <div class="field">
        <input class="easyui-textbox" name="city" style="width:80%" data-options="label:'市区名称：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="provinceCode" style="width:80%" data-options="label:'所属省份：',required:true">
    </div>
</form>
<script>
	<#if city??>
    $(function () {
      //需要延迟一点执行，等待页面所有组件都初始化好，再执行数据初始化
      setTimeout(function () {
        var city = ${city};
        if (city.roles) {
          var roles = [];
          $.each(city.roles, function () {
            roles.push(this.id);
          });
          member.roles = roles.join(",");
        }
        $("#city-form").form("load", city);
      }, 200);
    });
	</#if>
</script>