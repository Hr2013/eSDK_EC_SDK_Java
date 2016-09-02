package com.huawei.esdk.ec.demo.util;

public class StringUtils
{
    public static String formatJson(String jsonStr)
    {
        if (null == jsonStr || "".equals(jsonStr))
            return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++)
        {
            last = current;
            current = jsonStr.charAt(i);
            switch (current)
            {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\')
                    {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }
        
        return sb.toString();
    }
    
    private static void addIndentBlank(StringBuilder sb, int indent)
    {
        for (int i = 0; i < indent; ++i)
        {
            sb.append("  ");
        }
    }
    
    public static void main(String[] args)
    {
        String jsonString = "{\"callbackUrls\":[{\"wsUri\":\"http://10.170.32.113:8080/eSDK_EC_Callback_Java/callbackServlet\",\"module\":\"eserver\"}]}";
        System.out.println(formatJson(jsonString));
    }
}
