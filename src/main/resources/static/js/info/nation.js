define(function () {
  return function () {
    var dg = $("#nation_dg");
    var searchFrom = $("#nation_search_from");
    var form;

    // 使用edatagrid，需要而外导入edatagrid扩展
    dg.datagrid({
      url: '/info/nation/list',
      emptyMsg: "还未创建省份信息",
      idField: "nationCode",
      fit: true,
      rownumbers: true,
      fitColumns: true,
      border: false,
      pagination: true,
      singleSelect: true,
      ignore: ['roles'],
      pageSize: 30,
      columns: [[{
        field: 'nationCode',
        title: '民族编号',
        width: 30,
        editor: {
          type: 'validatebox',
          options: {
            required: true
          }
        },
        formatter: function (val) {
          return filterXSS(val);
        }
      }, {
          field: 'nation',
          title: '名族',
          width: 30,
          editor: {
              type: 'validatebox',
              options: {
                  required: true
              }
          },
          formatter: function (val) {
              return filterXSS(val);
          }
      },
        {
          field: 'test',
          title: '操作',
          width: 50,
          align: 'center',
          formatter: function (value, row, index) {
            return authToolBar({
              "member-edit": '<a data-id="' + row.nationCode + '" class="ctr ctr-edit">编辑</a>',
              "member-delete": '<a data-id="' + row.nationCode + '" class="ctr ctr-delete">删除</a>'
            }).join("");
          }
        }
      ]],
      toolbar: authToolBar({
        "member-create": {
          iconCls: 'fa fa-plus-square',
          text: "创建",
          handler: function () {
            createForm()
          }
        }
      })
    });


      /**
       * 操作按钮绑定事件
       */
      dg.datagrid("getPanel").on('click', "a.ctr-edit", function () {// 编辑按钮事件
          createForm.call(this, this.dataset.id)
      }).on('click', "a.ctr-delete", function () {// 删除按钮事件
          var id = this.dataset.id;
          $.messager.confirm("删除提醒", "确认删除此民族信息?", function (r) {
              if (r) {
                  $.get("/info/nation/delete", {id: id}, function () {
                      // 数据操作成功后，对列表数据，进行刷新
                      dg.datagrid("reload");
                  });
              }
          });
      });

      /**
       * 搜索区域事件
       */
      searchFrom.on('click', 'a.searcher', function () {//检索
          dg.datagrid('load', searchFrom.formToJson());
      }).on('click', 'a.reset', function () {//重置
          searchFrom.form('reset');
          dg.datagrid('load', {});
      });


      /**
       * 创建表单窗口
       *
       * @returns
       */
      function createForm(id) {
          var dialog = $("<div/>", {class: 'noflow'}).dialog({
              title: (id ? "编辑" : "创建") + "省份",
              iconCls: 'fa ' + (id ? "fa-edit" : "fa-plus-square"),
              height: id ? 380 : 420,
              width: 420,
              href: '/info/nation/form',
              queryParams: {
                  "id": id
              },
              modal: true,
              onClose: function () {
                  $(this).dialog("destroy");
              },
              onLoad: function () {
                  //窗口表单加载成功时执行
                  form = $("#nation-form");
              },
              buttons: [{
                  iconCls: 'fa fa-save',
                  text: '保存',
                  handler: function () {
                      if (form.form('validate')) {
                          $.post("/info/nation/save", form.serialize(), function (res) {
                              dg.datagrid('reload');
                              dialog.dialog('close');
                          })
                      }
                  }
              }]
          });
      }
  }
});