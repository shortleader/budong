/**
 * 	더보기  리스트  구현하기
 */ 

$(window).on('load', function () {
	console.log('Start Javascript');
    load('#js-load', '4');
    $("#js-btn-wrap .button").on("click", function () {
        load('#js-load', '4', '#js-btn-wrap');
    })
});
 
function load(id, cnt, btn) {
	// items_list = #js-load.js-load:not(.active)
	// items_length = #js-load.js-load:not(.active).length   
	//             : 표현이  안된(display:none) list의  개수
    var items_list = id + ".td__item:not(.active)";
    var items_length = $(items_list).length;
    var items_total_cnt;
    
    console.log('items_length = ' + items_length);
    if (cnt < items_length) {		// 
        items_total_cnt = cnt;
    } else {
    	console.log('not enough item in list. hide [more] button');
        items_total_cnt = items_length;
        $('.button').hide()
    }           
    $(items_list + ":lt(" + items_total_cnt + ")").addClass("active");
    // #js-load.td__item:not(.active):lt(totalcnt).addClass(active);
	console.log('load cnt : ' + items_total_cnt);
}