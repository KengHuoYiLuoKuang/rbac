<div class="easyui-layout" fit="true">
  <div data-options="region:'north',border:false" style="height: 80px;padding: 10px;overflow: hidden;" title="市区信息">
    <form id="city_search_from" class="searcher-form">
      <input name="cityCode" class="easyui-textbox field" label="市区编号：" labelWidth="45">
      <input name="city" class="easyui-textbox field" label="市区名称：" labelWidth="45">
        <input name="cityCode" class="easyui-textbox field" label="所属省份编号：" labelWidth="45">
        <a class="easyui-linkbutton searcher" data-options="iconCls:'fa fa-search'">检索</a>
      <a class="easyui-linkbutton reset" data-options="iconCls:'fa fa-repeat'">重置</a>
    </form>
  </div>
  <div data-options="region:'center',border:false" style="border-top: 1px solid #D3D3D3">
    <table id="city_dg"></table>
  </div>
</div>