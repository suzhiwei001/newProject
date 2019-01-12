/**
 * 接口关系展示管理初始化
 */
var TimsTaskIfInfo = {
    id: "TimsTaskIfInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TimsTaskIfInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '接口id', field: 'ifId', visible: true, align: 'center', valign: 'middle'},
            {title: '接口类型', field: 'ifType', visible: true, align: 'center', valign: 'middle'},
            {title: '接口英文名称', field: 'ifEnname', visible: true, align: 'center', valign: 'middle'},
            {title: '接口中文名称', field: 'ifCnname', visible: true, align: 'center', valign: 'middle'},
            {title: '所属环境', field: 'envType', visible: true, align: 'center', valign: 'middle'},
            {title: '接口维护方应用', field: 'appSname', visible: true, align: 'center', valign: 'middle'},
            {title: '接口状态', field: 'ifStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '维护人', field: 'modifyUder', visible: true, align: 'center', valign: 'middle'},
            {title: '维护部门', field: 'modifyDept', visible: true, align: 'center', valign: 'middle'},
            {title: '最后更新时间', field: 'modifyTime', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'timsUpdt', visible: true, align: 'center', valign: 'middle'},
            {title: '工银亚洲调用细分标志', field: 'callflag', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TimsTaskIfInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TimsTaskIfInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加接口关系展示
 */
TimsTaskIfInfo.openAddTimsTaskIfInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加接口关系展示',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/timsTaskIfInfo/timsTaskIfInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看接口关系展示详情
 */
TimsTaskIfInfo.openTimsTaskIfInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '接口关系展示详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/timsTaskIfInfo/timsTaskIfInfo_update/' + TimsTaskIfInfo.seItem.ifId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除接口关系展示
 */
TimsTaskIfInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/timsTaskIfInfo/delete", function (data) {
            Feng.success("删除成功!");
            TimsTaskIfInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("timsTaskIfInfoId",this.seItem.ifId);
        ajax.start();
    }
};

/**
 * 查询接口关系展示列表
 */
TimsTaskIfInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TimsTaskIfInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TimsTaskIfInfo.initColumn();
    var table = new BSTable(TimsTaskIfInfo.id, "/timsTaskIfInfo/list", defaultColunms);
    table.setPaginationType("client");
    TimsTaskIfInfo.table = table.init();
});
window.top["ss"] =  function (){
	console.info(111);
	return $('#'+ TimsTaskIfInfo.id).bootstrapTable('getData');
};
TimsTaskIfInfo.TimsTaskIfInfoGetData =  function (){
	console.info(111);
	return $('#'+ TimsTaskIfInfo.id).bootstrapTable('getData');
};
