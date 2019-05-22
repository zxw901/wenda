<html>
<body>
<pre>

    ${value1}
    <#list colors as color>
        This is color: ${color}
    </#list>
    <#if (colors[0]=="RED")>
        This is RED
    </#if>

    <#list ["星期一","星期二","星期三","星期四","星期五"] as x>
       ${x};
    </#list>

    <#list map?keys as key>
        This is key:${key}
        This is value:${map[key]}
    </#list>


    <#assign lastUpdated = "2009-01-07 15:05"?datetime("yyyy-MM-dd HH:mm") />
      ${lastUpdated?string("yyyy-MM-dd HH:mm:ss zzzz")};
      ${lastUpdated?string("EEE,MMM d,yy")};
      ${lastUpdated?string("EEEE,MMMM dd,yyyy,hh:mm:ss a '('zzz')'")};
      ${lastUpdated?string.short};
      ${lastUpdated?string.long};
<#--      ${lastUpdated?String.full};-->

    <#assign test1 = "2009-01-22"?date("yyyy-MM-dd") />;
    <#assign test2 ="16:34:43"?time("HH:mm:ss") />
    <#assign test2 = "2009-01-22 17:23:45"?datetime("yyyy-MM-dd HH:mm:ss") />
    ${test1?string.full}

    User:${user.name}
    User:${user.description}
    User:${user.getDescription()}

    <#assign title="nowcoder_title"/>
    Title:${title}

    <#include "header.ftl" parse=false>
    <#include "header.ftl">

    <#macro render_color index color>
        Color Render Macro ${index},${color}
    </#macro>

    <#list colors as color>
        <@render_color "${color_index}" "${color}"></@render_color>
    </#list>

    <#macro greet person>
        <font size="+2">Hello ${person}!</font>
    </#macro>
    <@greet "world"></@greet>

    <#assign hello="hello">
    <#assign helloworld="${hello} world">
    <#assign helloworld2='${hello} world'>     <#-- 单引号都能解析？？？-->

    ${hello}
    ${helloworld}
    ${helloworld2}
</pre>
</html>
</body>
