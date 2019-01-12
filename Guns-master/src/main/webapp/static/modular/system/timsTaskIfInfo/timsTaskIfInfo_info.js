/**
 * 初始化接口关系展示详情对话框
 */
var TimsTaskIfInfoInfoDlg = {
    timsTaskIfInfoInfoData : {}
};

/**
 * 清除数据
 */
TimsTaskIfInfoInfoDlg.clearData = function() {
    this.timsTaskIfInfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TimsTaskIfInfoInfoDlg.set = function(key, val) {
    this.timsTaskIfInfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TimsTaskIfInfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TimsTaskIfInfoInfoDlg.close = function() {
    parent.layer.close(window.parent.TimsTaskIfInfo.layerIndex);
}

/**
 * 收集数据
 */
TimsTaskIfInfoInfoDlg.collectData = function() {
    this
    .set('ifId')
    .set('ifType')
    .set('ifEnname')
    .set('ifCnname')
    .set('envType')
    .set('appSname')
    .set('ifStatus')
    .set('modifyUder')
    .set('modifyDept')
    .set('modifyTime')
    .set('remark')
    .set('timsUpdt')
    .set('callflag');
}

/**
 * 提交添加
 */
TimsTaskIfInfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/timsTaskIfInfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.TimsTaskIfInfo.table.refresh();
        TimsTaskIfInfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    this.timsTaskIfInfoInfoData["wodeceshi"]="取值";
    console.info(JSON.stringify(window.top["ss"]()));
    //console.info(JSON.stringify(window.parent.TimsTaskIfInfo.TimsTaskIfInfoGetData()));
    ajax.set("fff",JSON.stringify(this.timsTaskIfInfoInfoData));
    ajax.start();
}

/**
 * 提交修改
 */
TimsTaskIfInfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/timsTaskIfInfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.TimsTaskIfInfo.table.refresh();
        TimsTaskIfInfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.timsTaskIfInfoInfoData);
    ajax.start();
}

$(function() {

});
