function pgfxLoadBlankBroadcasterImage(){return!1}var oapBootstrapVer="2013-06-24-11-28",_gaq=_gaq||[],lifestyleIndexToDFP={golf:69749050,driving:69749170,"air-travel":69749290,"sun-sand":69749410,fishing:69749530,sailing:69749650,ski:69749770,"school-day":69749890,allergies:69750010,running:69750130,astronomy:69750250,hunting:69750610,"lawn-garden":69750730,biking:69750850,hiking:69750970,diy:69751090,"outdoor-entertaining":69751210,"snow-day":69751330,"cold-flu":69751570,"home-energy":69751690,events:69751810,"hair-day":69751930,asthma:69752050,migraine:69752170,arthritis:69752410,sinus:69752650};!function(){function e(){s=window.jQuery.noConflict(!0),a()}function t(){document.getElementsByClassName("aw-widget-36hour-inner")[0].style.maxWidth="none",document.getElementsByClassName("aw-six-hours")[0].remove(),document.getElementsByClassName("aw-more-block aw-more-block-first")[0].remove(),document.getElementsByClassName("aw-more-sep-2")[0].remove(),document.getElementsByClassName("aw-more-block")[0].remove(),document.getElementsByClassName("aw-more-sep-3")[0].remove(),document.getElementsByClassName("aw-more-block")[0].remove(),document.getElementsByClassName("aw-temp-unit")[0].remove(),document.getElementsByClassName("aw-get-this-widget")[0].remove()}function a(){i(),s(document).ready(function(e){if(-1!=document.domain.indexOf("accuweather")||e(".aw-widget-legal").length){e.each(c.css,function(t,a){var n="aw-widget-css-"+t;e("#"+n).length||e("<link>",{id:n,rel:"stylesheet",type:"text/css",href:a}).appendTo("head")});var a=s(c.current.selector).add(c.threeday.selector),n=e();a.each(function(){this.awInit||n.length||(n=e(this),this.awType=-1!=n.data("uid").indexOf("awcc")?"current":"threeday",this.awInit=!0)}),n.html('<span class="message">Loading Widget…</span>'),(a=n.data()).css&&!e("#aw-widget-client-css").length&&e("<link>",{id:"aw-widget-client-css",rel:"stylesheet",type:"text/css",href:a.css}).appendTo("head"),a.css=null,s.getJSON(c[n.get(0).awType].url+"?callback=?",a,function(a){a.style&&e('<style type="text/css">'+a.style+"</style>").appendTo("head"),n.html(a.html),r(s,n),t()})}else alert("It seems the widget code is incomplete. Please visit http://www.accuweather.com/en/free-weather-widgets to set up your free weather widget.")})}function n(e){e.html('<span class="message">Loading Widget…</span>'),e.get(0).awInit=!1;var t=e.data();t.widget=null;var a;s(c.current.selector).add(c.threeday.selector).each(function(){this.awInit&&s(this).data("uid").substr(4)==e.data("uid").substr(4)&&((a=s(this)).data("locationkey",e.data("locationkey")),a.data("unit",e.data("unit")),-1!=a.data("uid").indexOf("awcc")?(this.awType="current",a.awType="current"):(this.awType="threeday",a.awType="threeday"))}),e.get(0).awInit=!0,s.getJSON(c[e.get(0).awType].url+"?callback=?",t,function(t){e.html(t.html),r(s,e)}),a&&(t=a.data(),t.widget=null,s.getJSON(c[a.awType].url+"?callback=?",t,function(e){a.html(e.html),r(s,a)}))}function i(){!function(e,t){var a;e.throttle=a=function(a,n,i,r){function s(){function e(){c=+new Date,i.apply(s,l)}var s=this,u=+new Date-c,l=arguments;r&&!o&&e(),o&&clearTimeout(o),r===t&&u>a?e():!0!==n&&(o=setTimeout(r?function(){o=t}:e,r===t?a-u:a))}var o,c=0;return"boolean"!=typeof n&&(r=i,i=n,n=t),e.guid&&(s.guid=i.guid=i.guid||e.guid++),s},e.debounce=function(e,n,i){return i===t?a(e,n,!1):a(e,i,!1!==n)}}(s),function(e){e.autocomplete=function(t,a){function i(){I={data:{},length:0}}function r(){h(document.getElementById(p.attr("id")).value,"search")}function s(t){var a=e("li",y);a&&(C+=t,0>C?C=0:C>=a.size()&&(C=a.size()-1),a.removeClass("aw-ac-hover"),e(a[C]).addClass("aw-ac-hover"),a[C]&&a[C].scrollIntoView&&a[C].scrollIntoView(!1))}function o(){b&&clearTimeout(b),y.hide()}function u(t,i,r){if(i){if(p.removeClass(a.loadingClass),y.html(""),"search"==r){if(!i.length)return y.html('<div class="aw-no-results">No Matching Results Found</div>'),void y.show();if(1==i.length)return(t=y.closest(c.threeday.selector)).data("locationkey",i[0][1]),t.data("useip","false"),void n(t)}else if(!k||0==i.length)return o();y.html(d(i)),y.find("a").each(function(t){e(this).click(function(){var t=e(this).closest(c.threeday.selector);t.data("locationkey",e(this).data("key")),t.data("useip","false"),n(t)})}),y.show()}else o()}function l(e){if(!e)return null;for(var t=[],a=0;a<e.length;a++){var n,i;e[a]&&(n=e[a],i=[n.LocalizedName],"US"==n.Country.ID||"CA"==n.Country.ID||"AU"==n.Country.ID?i.push(", "+n.AdministrativeArea.ID):"GB"==n.Country.ID?void 0!==n.SupplementalAdminAreas&&n.SupplementalAdminAreas.length?i.push(", "+n.SupplementalAdminAreas[0].LocalizedName):i.push(", "+n.AdministrativeArea.ID):n.AdministrativeArea.LocalizedName!=n.LocalizedName&&i.push(", "+n.AdministrativeArea.LocalizedName),"US"==n.Country.ID?i.push(" (USA)"):i.push(" ("+n.Country.LocalizedName+")"),i=i.join(""),(n=[]).push(i),n.push(e[a].Key),t.push(n))}return t}function d(e){var t=e.length;0<a.maxItemsToShow&&a.maxItemsToShow<t&&(t=a.maxItemsToShow);for(var n=[],i=0;i<t;i++)n.push('<li class="aw-location"><a data-key="'+e[i][1]+'">'+e[i][0]+"</a></li>");return n?"<ul>"+n.join("")+"</ul>":""}function h(t,n){a.matchCase||(t=t.toLowerCase()),a.cacheLength&&g(t),"string"==typeof a.url&&0<a.url.length?e.ajax({type:"GET",url:w(t,n),cache:!0,dataType:"jsonp",success:function(e){e=l(e),m(t,e),u(t,e,n)}}):p.removeClass(a.loadingClass)}function w(e,t){"search"!=t&&(t="autocomplete");var n,i=a.url+t+"?q="+encodeURI(e)+"&apiKey="+a.api_key;for(n in a.extraParams)i+="&"+n+"="+encodeURI(a.extraParams[n]);return i}function g(e){if(!e)return null;if(I.data[e])return I.data[e];if(a.matchSubset)for(n=e.length-1;n>=a.minChars;n--){var t=e.substr(0,n);if(t=I.data[t]){for(var n=[],i=0;i<t.length;i++){var r,s=t[i];r=s[0];var o=e;a.matchCase||(r=r.toLowerCase()),(r=-1!=(r=r.indexOf(o))&&(0==r||a.matchContains))&&(n[n.length]=s)}return n}}return null}function f(e,t){t&&p.removeClass(a.loadingClass);for(var n=t?t.length:0,i=null,r=0;r<n;r++){var s=t[r];if(s[0].toLowerCase()==e.toLowerCase()){if((i=document.createElement("li")).innerHTML=a.formatItem?a.formatItem(s,r,n):s[0],i.selectValue=s[0],o=null,1<s.length)for(var o=[],c=1;c<s.length;c++)o[o.length]=s[c];i.extra=o}}a.onFindValue&&setTimeout(function(){a.onFindValue(i)},1)}function m(e,t){t&&e&&a.cacheLength&&(!I.length||I.length>a.cacheLength?(i(),I.length++):I[e]||I.length++,I.data[e]=t)}var p=t.attr("autocomplete","off");a.inputClass&&p.addClass(a.inputClass);var y=e(".aw-autocomplete"),v=e(".aw-submit-button");t.autocompleter=this;var b=null,x="",C=-1,I={},k=!1,T=null;if(i(),null!=a.data){var W="",S={},A=[];"string"!=typeof a.url&&(a.cacheLength=1);for(var L=0;L<a.data.length;L++)0<(A="string"==typeof a.data[L]?[a.data[L]]:a.data[L])[0].length&&(W=A[0].substring(0,1).toLowerCase(),S[W]||(S[W]=[]),S[W].push(A));for(var j in S)a.cacheLength++,m(j,S[j])}v.click(function(){r()}),p.bind("keydown",function(t){switch(T=t.keyCode,t.keyCode){case 38:t.preventDefault(),s(-1);break;case 40:t.preventDefault(),s(1);break;case 9:t.preventDefault();break;case 13:var i=e("li",y);t.preventDefault(),e(i).hasClass("aw-ac-hover")?((t=y.closest(c.threeday.selector)).data("locationkey",e(i[C]).find("a").data("key")),t.data("useip","false"),n(t)):r();break;default:C=-1,b&&clearTimeout(b),b=setTimeout(function(){if(46==T||8<T&&32>T)y.hide();else{var e=document.getElementById(p.attr("id")).value;e!=x&&(x=e,e.length>=a.minChars?(p.addClass(a.loadingClass),h(e,"autocomplete")):(p.removeClass(a.loadingClass),y.hide()))}},a.delay)}}).bind("focus",function(){k=!0}).bind("blur",function(){k=!1,b&&clearTimeout(b),b=setTimeout(o,200)}),o(),this.flushCache=function(){i()},this.setExtraParams=function(e){a.extraParams=e},this.findValue=function(){var t=document.getElementById(p.attr("id")).value;a.matchCase||(t=t.toLowerCase());var n=a.cacheLength?g(t):null;n?f(t,n):"string"==typeof a.url&&0<a.url.length?e.ajax({type:"GET",url:w(t,"autocomplete"),cache:!0,dataType:"jsonp",success:function(e){e=l(e),m(t,e),u(t,e,"autocomplete")}}):f(t,null)}},e.fn.autocomplete=function(t,a,n){return a=a||{},a.url=t,a.data="object"==typeof n&&n.constructor==Array?n:null,a.inputClass=a.inputClass||"ac_input",a.resultsClass=a.resultsClass||"ac_results",a.lineSeparator=a.lineSeparator||"\n",a.cellSeparator=a.cellSeparator||"|",a.minChars=a.minChars||1,a.delay=a.delay||400,a.matchCase=a.matchCase||0,a.matchSubset=a.matchSubset||1,a.matchContains=a.matchContains||0,a.cacheLength=a.cacheLength||1,a.mustMatch=a.mustMatch||0,a.extraParams=a.extraParams||{},a.loadingClass=a.loadingClass||"ac_loading",a.selectFirst=a.selectFirst||!1,a.selectOnly=a.selectOnly||!1,a.maxItemsToShow=a.maxItemsToShow||-1,a.autoFill=a.autoFill||!1,a.width=parseInt(a.width,10)||0,new e.autocomplete(e(this),a),e(this)},e.fn.autocompleteArray=function(e,t){return this.autocomplete(null,t,e)},e.fn.indexOf=function(e){for(var t=0;t<this.length;t++)if(this[t]==e)return t;return-1}}(s)}function r(e,t){if("undefined"!=typeof awxOapIE8)for(var a=[{o:".aw-widget-36hour .tbg-su, .aw-widget-36hour .bg-su, .aw-widget-current .tbg-su, .aw-widget-current .bg-su",c:"background",s:"#6cb2fc"},{o:".aw-widget-36hour .tbg-c, .aw-widget-36hour .bg-c, .aw-widget-current .tbg-c, .aw-widget-current .bg-c",c:"background",s:"#d0dae8"},{o:".aw-widget-36hour .tbg-f, .aw-widget-36hour .bg-f, .aw-widget-current .tbg-f, .aw-widget-current .bg-f",c:"background",s:"#dee4ef"},{o:".aw-widget-36hour .tbg-t, .aw-widget-36hour .bg-t, .aw-widget-current .tbg-t, .aw-widget-current .bg-t",c:"background",s:"#90bbe5"},{o:".aw-widget-36hour .tbg-r, .aw-widget-36hour .bg-r, .aw-widget-current .tbg-r, .aw-widget-current .bg-r",c:"background",s:"#7789b2"},{o:".aw-widget-36hour .tbg-cl, .aw-widget-36hour .bg-cl, .aw-widget-current .tbg-cl, .aw-widget-current .bg-cl",c:"background",s:"#141414"},{o:".aw-widget-36hour .tbg-s, .aw-widget-36hour .bg-s, .aw-widget-current .tbg-s, .aw-widget-current .bg-s",c:"background",s:"#141414"},{o:"div.aw-widget-36hour-inner div.aw-widget-content div.aw-header div.aw-search button.aw-submit-button",c:"border",s:"none !important"}],i=0;i<a.length;i++)e(a[i].o).css(a[i].c,a[i].s);window.accuweather=window.accuweather||{},window.accuweather.widgets=window.accuweather.widgets||{register:function(t,a){var n=e(t);n.length&&(window.accuweather.widgets[n.get(0)]=a)},get:function(t){if((t=e(t)).length)return window.accuweather.widgets[t.get(0)]}},window.accuweather.widgets.Current=function(t){var a=this;this.el=e(t),this.breakpoints=[86,106,115,216,280,350,479],this.inner=this.el.find(".aw-widget-current-inner"),this.inow=this.el.find(".aw-current-weather .aw-icon"),this.clickUrl=this.el.find(".aw-widget-current-inner a").first(),-1==this.clickUrl.attr("href").toString().toLowerCase().indexOf("accuweather.com")&&this.clickUrl.removeAttr("target"),this.reload=function(){n(t)},this.resize(),this.toggle=this.el.find(".aw-toggle"),this.toggle.click(function(){return a.inner.addClass("with-get"),!1}),window.accuweather.widgets.register(this.el.get(0),this)},window.accuweather.widgets.Current.prototype.resize=function(){for(var e=this.el.outerWidth(),t=[],a=!1,n=0;n<this.breakpoints.length;n++){var i=this.breakpoints[n];e<i&&(t.push("lt-"+i),a=!0),e==i&&t.push("eq-"+i)}a||(t=["gte-"+this.breakpoints[this.breakpoints.length-1]]),this.el.attr("class",c.current.baseClass+" "+t.join(" ")),a=this.inow.data("icon"),n="l",216>e&&(n="m"),115>e&&(n="t"),this.inow.attr("class","aw-icon aw-icon-"+a+"-"+n),this.el.find(".debug .width").html(e),this.el.find(".debug .bpclasses").html(t.join(" ")),this.el.hide(),this.el.show()},window.accuweather.widgets.ThirtySixHour=function(a){function i(e){return awxWidgetInfo[o].wxInfo.ut&&"1"==awxWidgetInfo[o].wxInfo.ut?9*e/5+32:e}function r(e,t){for(var a in t)switch(a){case"hi":case"lo":awxWidgetInfo[o].keyValuePairs[e+a]=5*Math.round(i(parseInt(t[a]))/5);break;case"wx":awxWidgetInfo[o].keyValuePairs[e+a]=parseInt(t[a]);break;default:awxWidgetInfo[o].keyValuePairs[e+a]=t[a]}}this.el=e(a),this.breakpoints=[320,480,540,624,632,780,860,950],this.i36=this.el.find(".aw-36-hours .aw-icon"),this.inow=this.el.find(".aw-current-weather .aw-icon"),this.search=this.el.find(".aw-search"),this.reload=function(){n(a)},this.moveTimeBubble=function(){setTimeout(function(){var t=(i=e(".aw-widget-36hour").find(".aw-time-bubble")).find("span"),a=i.find("i"),n=i.find("b"),i=i.attr("data-minutes")/60,r=e(".aw-six-hours-inner ul li:first").width(),n=n.width(),i=Math.max(5,r*i),n=(i=Math.min(n-7,i))+6;t.css("left",i+"px"),a.css("left",n+"px")},100)},t.find(".aw-temp-unit").find("li a").each(function(a){e(this).click(function(){e(this).closest("li").hasClass("current")||(e(this).hasClass("aw-unit-f")?t.data("unit","f"):t.data("unit","c"),t.data("useip","false"),n(t))})});var s=this.el.find(".aw-autocomplete");this.el.find(".aw-search input").bind({focus:function(){e(this).closest(".aw-search").addClass("aw-focus"),e(this).val("");var t=e(this).position().top+e(this).height()+16;e(".aw-emergency-header").length&&(t+=e(".aw-emergency-header").height()+10),s.css({width:e(this).width(),top:t,left:e(this).position().left})},blur:function(){e(this).closest(".aw-search").removeClass("aw-focus")}}).autocomplete("https://api.accuweather.com/locations/v1/cities/",{el:this.el.get(0),api_key:"651aa630aeac48e8b15f9072cfa524bc",autoFill:1,inputClass:"aw-input",resultsClass:"aw-autocomplete",minChars:1,cacheLength:0,matchSubset:1,matchCase:0,matchContains:1,maxItemsToShow:8,mustMatch:0});var o=this.el.data("uid");if(awxWidgetInfo[o].keyValuePairs={zip:awxWidgetInfo[o].userInfo.zip,city:awxWidgetInfo[o].userInfo.city,state:awxWidgetInfo[o].userInfo.state,country:awxWidgetInfo[o].userInfo.country,partner:awxWidgetInfo[o].userInfo.sessionPartner,metro:awxWidgetInfo[o].userInfo.metro,dma:awxWidgetInfo[o].userInfo.dma,lang:awxWidgetInfo[o].userInfo.lang},awxWidgetInfo[o].wxInfo)for(var c in awxWidgetInfo[o].wxInfo)if("ix"!=c)if("cu"==c)for(var u in awxWidgetInfo[o].wxInfo[c])awxWidgetInfo[o].wxInfo[c][u]&&r("cu",awxWidgetInfo[o].wxInfo[c]);else if("fc"==c)for(var l=0;l<awxWidgetInfo[o].wxInfo[c].length;l++)for(u in awxWidgetInfo[o].wxInfo[c][l])awxWidgetInfo[o].wxInfo[c][l][u]&&r("fc"+(l+1),awxWidgetInfo[o].wxInfo[c][l]);else awxWidgetInfo[o].wxInfo[c]&&(awxWidgetInfo[o].keyValuePairs[c]=awxWidgetInfo[o].wxInfo[c].toString());this.resize(),window.accuweather.widgets.register(this.el.get(0),this)},window.accuweather.widgets.ThirtySixHour.prototype.resize=function(){for(var t=this.el.outerWidth(),a=[],n=!1,i=0;i<this.breakpoints.length;i++){var r=this.breakpoints[i];t<r&&(a.push("lt-"+r),n=!0),t==r&&a.push("eq-"+r)}n||(a=["gte-"+this.breakpoints[this.breakpoints.length-1]]),this.el.attr("class",c.threeday.baseClass+" "+a.join(" ")),this.i36.each(function(){var a=e(this),n=a.data("icon"),i="m";950>t&&(i="s"),a.attr("class","aw-icon aw-icon-"+n+"-"+i)}),a=this.inow.data("icon"),this.inow.attr("class","aw-icon aw-icon-"+a+"-"+(480>t?"m":"xl")),this.moveTimeBubble(),$table=e(".vid-headline-box"),$table.find("td.logo").css("width",$table.outerHeight(!0)+"px")};var r="current"==t.get(0).awType?new window.accuweather.widgets.Current(t):new window.accuweather.widgets.ThirtySixHour(t);e(window).resize(e.throttle(200,function(){r.resize()})),"current"==t.get(0).awType?window.accuweatherWidgetCurrentReady&&window.accuweatherWidgetCurrentReady(t.get(0),r):window.accuweatherWidgetThirtySixHourReady&&window.accuweatherWidgetThirtySixHourReady(t.get(0),r);var s=t.data("uid")?t.data("uid"):"aw"+(new Date).getTime(),a=t.data("lifestyle")?"/"+t.data("lifestyle"):"",i=t.get(0).awType+a;""!=a&&t.data("lifestyle");try{(function(e,t,a,n,i,r,s){e.GoogleAnalyticsObject=i,e[i]=e[i]||function(){(e[i].q=e[i].q||[]).push(arguments)},e[i].l=1*new Date,r=t.createElement(a),s=t.getElementsByTagName(a)[0],r.async=1,r.src="//www.google-analytics.com/analytics.js",s.parentNode.insertBefore(r,s)})(window,document,"script",0,"ga_awxoap"),ga_awxoap("create","UA-31945348-1","auto",{name:"awxoapTracker"}),ga_awxoap("awxoapTracker.set","page","/oap-weather-widgets/"+i),ga_awxoap("awxoapTracker.send","pageview",{dimension1:"OAP_Weather_Widgets",dimension2:document.domain?document.domain.split(".").join("-"):"OAP_NoDomain",dimension3:awxWidgetInfo[s].userInfo.partner,dimension4:"OAP_Widget_"+i,dimension5:awxWidgetInfo[s].wxInfo.mcpct})}catch(e){}e("#"+s).find("a").each(function(){if(e(this).attr("id")&&"#"!=e(this).attr("href")){var a=e(this).attr("href");e(this).attr("id");var n=[];n.push("utm_source="+(document.domain?document.domain.split(".").join("-"):"OAP_NoDomain")),n.push("utm_medium=oap_weather_widget"),n.push("utm_term="+e(this).attr("id")),n.push("utm_content="+awxWidgetInfo[s].userInfo.partner),n.push("utm_campaign="+t.get(0).awType),-1!=a.indexOf("?")?e(this).attr("href",a+"&"+n.join("&")):e(this).attr("href",a+"?"+n.join("&"))}})}document&&document.URL&&document.URL.indexOf("/adc/");var s;if(void 0!==window.jQuery&&window.jQuery.fn.jquery.match(/^1\.9/))s=window.jQuery,a();else{var o=document.createElement("script");o.setAttribute("type","text/javascript"),o.setAttribute("src","https://vortex.accuweather.com/adc2010/oap/javascript/jquery-1.9.1.min.js"),o.readyState?o.onreadystatechange=function(){"complete"!=this.readyState&&"loaded"!=this.readyState||e()}:o.onload=e,(document.getElementsByTagName("head")[0]||document.documentElement).appendChild(o)}var c={current:{},threeday:{}};"undefined"!=typeof oap3dayConfigDev?(c.css=oap3dayConfigDev.css,c.threeday.selector=oap3dayConfigDev.threedaySelector,c.threeday.baseClass=oap3dayConfigDev.threedayBaseClass,c.threeday.url=oap3dayConfigDev.threedayUrl,c.current.selector=oap3dayConfigDev.currentSelector,c.current.baseClass=oap3dayConfigDev.currentBaseClass,c.current.url=oap3dayConfigDev.currentUrl):(c.css=["https://vortex.accuweather.com/adc2010/oap/stylesheets/widgets-20170109.css"],c.threeday.selector=".aw-widget-36hour",c.threeday.baseClass="aw-widget-36hour",c.threeday.url=window.location.protocol+"//www.accuweather.com/ajax-service/oap/3day",c.current.selector=".aw-widget-current",c.current.baseClass="aw-widget-current",c.current.url=window.location.protocol+"//www.accuweather.com/ajax-service/oap/current")}();
