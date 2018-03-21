/**
 * Created by hujiqing on 2017/4/3.
 */
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return (r[2]); return null;
}
var nowplace=GetQueryString("nowplace");
var fir_p=GetQueryString("fir_p");
var end_p=GetQueryString("end_p");


var map = new BMap.Map("lala");
var point = new BMap.Point(116.331398,39.897445);
map.centerAndZoom(point,12);
var myGeo = new BMap.Geocoder();
myGeo.getPoint(nowplace, function(point){
    if (point) {
        map.centerAndZoom(point, 11);
        map.addOverlay(new BMap.Marker(point));
    }else{
        
    }
}, "");
var driving = new BMap.DrivingRoute(map, {renderOptions: {map: map, panel: "baby", autoViewport: true}});
driving.search(fir_p,end_p);


    	XBack.listen(function(){
    window.open('planroute.html');
});
   