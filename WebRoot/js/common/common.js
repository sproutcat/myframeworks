

/**
 * 辅助工具类
 */
var util = (function() {
    return {
        /**
         * 打印日志
         *
         * 如：util.log("{1}test{0}", "!", "my ");
         *
         */
        log : function() {
            var len = arguments.length, 
                str = len < 2 ? arguments || "null" : this.format(arguments);

            if ( typeof console == "undefined" || !console){
                //alert(str);
                return false;
            }else {
                console.log(str);
            }
        },
        
        /**
         * 用于格式化string
         *
         * 如：util.format("{1}test{0}", "!", "my ");
         *
         */
        format : function(format) {
            var args = null, str = null, me = this;
            if ( typeof format == "string") {
                args = Array.prototype.slice.call(arguments, 1);
                str = format;
            } else {
                args = Array.prototype.slice.call(format, 1);
                str = format[0];
            }
            return me.template(str, args);
        },
        
        objectToString : function(object) {
            var source = [];
            for (var n in object) {
                if(Object.prototype.toString.call(object[n]) == "[object Array]"){
                    source.push("\"" + n + "\":" + this.arrayToString(object[n]));
                } else {
                    source.push("\"" + n + "\":" + object[n]);
                }
            }
            return "{" + source.join(',') + "}";
        },
        
        arrayToString: function(array) {
            var obj = Array.prototype.slice.call(array),
                src = [];
            for(var n = 0; n < obj.length; n++) {
                if(Object.prototype.toString.call(obj[n]) == "[object Object]"){
                    src.push(this.objectToString(obj[n]));
                }else{
                    src.push(obj[n]);
                }
            }
            return "[" + src.toString() + "]";
        }, 
        /**
         * 模板方法
         */
        template: function(str, data) {
        	var me = this;
        	if(data) {
        		return str.replace(/\{([\w\-]+)(?:\:([\w\.]*)(?:\((.*?)?\))?)?\}/g, function(m, i) {
        			if(!data[i]) {
        				return "";
        			} else if ( typeof data[i] == "string") {
	                    return data[i];
	                } else if (Object.prototype.toString.call(data[i]) == "[object Object]") {
	                    return me.objectToString(data[i]);
	                } else if (Object.prototype.toString.call(data[i]) == "[object Array]") {
	                    return me.arrayToString(data[i]);
	                } else {
	                    return data[i];
	                }
	        	});
        	} else {
        		return str;
        	}
        },
        //------------------------以下函数部分依赖于jQuery------------------------------
        unregisterLoadedUrl: function(url) {
            this.loadedLibrary[url] = false;
        },
        registerLoadedUrl: function(url) {
            this.loadedLibrary[url] = true;
        },
        loadedLibrary: {},
        toJsArray: function(jsObj) {
        	var rel = [];
        	for(var k in jsObj) {
        		rel.push({
        			xtype: k,
        			path: jsObj[k]
        		});
        	}
        	return rel;
        },
        loadJs: function(jsPath) {
        	var me = this;
        	switch(Object.prototype.toString.call(jsPath)) {
        		case "[object Array]": 
        			for(var i = 0; i < jsPath.length; i++) {
        				me.getJavaScript({
    						url: jsPath[i]["path"],
	                        success: function() {
	                            me.registerLoadedUrl(jsPath[i]["xtype"]);
	                        },
	                        error: function(msg) {
	                            me.unregisterLoadedUrl(jsPath[i]["xtype"]);
	                            throw "Communication";
	                        }
    					});
        			}
        			break;
    			case "[object Object]":
    				for(var key in jsPath) {
    					me.getJavaScript({
    						url: jsPath[key],
	                        success: function() {
	                            me.registerLoadedUrl(key);
	                        },
	                        error: function(msg) {
	                            me.unregisterLoadedUrl(key);
	                            throw "Communication";
	                        }
    					});
    				}
    				break;
				default:
					me.log("----path: {0}", jsPath);
        	}
        },
        getJavaScript: function(data) {
        	var me = this;
        	util.log("-----js path: {0}", data.url);
            jQuery.ajax({//同步提交
            	type : "GET",
            	url : data.url,
            	async : false,
            	success : function(response){
            		me.addScript(response, data.url);
                    data.success();
            	},
            	error: function(jqXHR, textStatus, errorThrown) {
            		data.error();
            	}
            });
        },
        getHtmlHead: function() {
            return document.getElementsByTagName("head")[0] || document.documentElement;
        },
        addScript: function(data, url) {
            var script = document.createElement("script");
            script.type = "text/javascript";
            if (this.isIE) {
                script.text = data;
            }
            else {
                script.appendChild(document.createTextNode(data));
            }
			script.id = url;
            var head = this.getHtmlHead();
            head.appendChild(script);
        },
        reloadJs : function(reloadJs){
    		jQuery("#" + reloadJs["xtype"]).remove();
			this.loadedLibrary[reloadJs["xtype"]] = false;
        	if(reloadJs['path'])
        		this.loadJs(reloadJs['path']);
        },
        isIE: function() {
        	var browser=navigator.appName;
        	return browser == "Microsoft Internet Explorer";
        }
    }
})();

