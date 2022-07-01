package com.eno.baozi.dangerous.report.convert;

import java.util.HashMap;
import java.util.Map;

public class SuggestConvert {

    public static Map<String,String> ESCAPE_SUGGEST = new HashMap<>();
    public static Map<String,String> VIOLENCE_SUGGEST = new HashMap<>();
    public static Map<String,String> SUICIDE_SUGGEST = new HashMap<>();
    static {
        ESCAPE_SUGGEST.put("极高度","该犯脱逃可能性极强，在特定场所或押解途中，很可能实施脱逃危险行为，望引起高度重视，并做好防范工作。");
        ESCAPE_SUGGEST.put("高度","该犯脱逃可能性强，在特定场所或押解途中，很可能实施脱逃危险行为，望引起高度重视，并做好防范工作。");
        ESCAPE_SUGGEST.put("中度","该犯具有脱逃的可能性，在特定场所或押解途中，很可能实施脱逃危险行为，望引起高度重视，并做好防范工作。");
        ESCAPE_SUGGEST.put("低度","");

        VIOLENCE_SUGGEST.put("极高度","该犯攻击性极强，遇到矛盾或挫折后，很可能发生暴力攻击危险行为，望引起高度重视，并做好防范工作。");
        VIOLENCE_SUGGEST.put("高度","该犯攻击性强，遇到矛盾或挫折后，很可能发生暴力攻击危险行为，望引起高度重视，并做好防范工作。");
        VIOLENCE_SUGGEST.put("中度","该犯具有攻击性，遇到矛盾或挫折后，很可能发生暴力攻击危险行为，望引起高度重视，并做好防范工作。");
        VIOLENCE_SUGGEST.put("低度","");

        SUICIDE_SUGGEST.put("极高度","该犯遇到挫折后，很可能诱发自伤自残，甚至自杀等危险行为，望做好教育疏导和防范工作。");
        SUICIDE_SUGGEST.put("高度","该犯遇到挫折后，很可能诱发自伤自残，甚至自杀等危险行为，望做好教育疏导和防范工作。");
        SUICIDE_SUGGEST.put("中度","该犯遇到挫折后，可能诱发自伤自残，甚至自杀等危险行为，望做好教育疏导和防范工作。");
        SUICIDE_SUGGEST.put("低度","");
    }

}
