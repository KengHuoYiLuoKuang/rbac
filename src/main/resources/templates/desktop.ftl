<div class="easyui-panel"  title="人口登记校验" style="width:480px">
<form class="app-form" id="population-form">
    <div class="field">
        <input id="name" class="easyui-textbox" name="realName" style="width:80%" data-options="label:'姓名：',required:true">
        <select class="easyui-combobox" editable="false" data-options="panelHeight:'auto'" name="gender" style="width:18%">
            <option value="BOY">男</option>
            <option value="GIRL">女</option>
        </select>
    </div>

    <div class="field">
        <input id="idCardNumber" class="easyui-textbox" name="idCardNumber" style="width:100%" data-options="label:'身份证：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="age" style="width:100%" data-options="label:'年龄：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="telephone" style="width:100%" data-options="label:'电话：',required:true">
    </div>
    <div class="field">
        <input  name="nation" style="width:100%" >
    </div>

    <div class="field">
        <input id="province" name="province" style="width:100%" data-options="label:'所在省份：',required:true">
    </div>
    <div class="field">
    <input id="city" name="city" style="width:100%" data-options="label:'所在省份：',required:true">
    </div>
    <div class="field">
    <input  id="region" class="easyui-combobox" name="village" style="width:100%" data-options="label:'区县：',required:true">
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
  //自定义验证规则
$(function () {
    $.extend($.fn.validatebox.defaults.rules, {
        onlytext:{
            validator:function(value,param){
                var reg = /^[\u4e00-\u9fa5]+$/;
                return reg.test(value);
            },
            message:  '只能输入汉字！'
        },
        idCardNumber:{
            validator:function(value,param){
                var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
                return reg.test(value);
            },
            message:'请输入正确的身份证号码！'
        },
        age:{
            validator:function(value,param){
                var reg = /^(?:[1-9][0-9]?|1[0-9][0-9])$/;
                return reg.test(value);
            },
            message:'年龄1-199！'
        },
        telephone:{
            validator:function(value,param){
                var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
                return reg.test(value);
            },
            message:'请输入正确的手机电话'
        }
    });
});



    $(function () {
        //姓名验证
        $("#name").textbox({
            required:true,
            validType:['onlytext','length[2,12]']
        });
        //身份证验证
        $("#idCardNumber").textbox({
            required:true,
            validType:'idCardNumber',
        });
        //年龄验证
        $("input[name='age']").textbox({
            required:true,
            validType:'age',
        });
        //年龄验证
        $("input[name='telephone']").textbox({
            required:true,
            validType:'telephone',
        });

//获取名族
        $("input[name='nation']").combobox({
            url:'/nation/list',
            valueField:'nationCode',
            textField:'nation',
            label:'民族：',
            required:true,
            method:'GET'
        });

        //获取省
        $("#province").combobox({
            url:'/province/list',
            valueField:'provinceCode',
            textField:'province',
            label:'所在省份：',
            required:true,
            method:'GET',
            onSelect: function(rec){
                var url = '/city/findcity?provinceCode='+rec.provinceCode;
                $("#city").combobox('clear');
                $("#region").combobox('clear');
                $("#city").combobox('reload',url);
            }
        });
        //获取市
        $("input[name='city']").combobox({
            //url:'/city/findcity?provinceCode=510000',
            valueField:'cityCode',
            textField:'city',
            label:'市区：',
            required:true,
            method:'GET',
            onSelect: function(rec){
                var url = '/region/findregion?cityCode='+rec.cityCode;
                $("#region").combobox('clear');
                $("#region").combobox('reload',url);
            }
        });
        //获取区
        $("#region").combobox({
            valueField:'regionCode',
            textField:'region',
            label:'区县：',
            required:true,
            method:'GET',
        });
    });


</script>