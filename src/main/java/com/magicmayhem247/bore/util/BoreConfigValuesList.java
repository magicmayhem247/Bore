package com.magicmayhem247.bore.util;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

public enum BoreConfigValuesList
{
    ZINC_CHANCE("zinc_times_rarer", "int"),
    ZINC_MAX_VEIN_SIZE("zinc_max_vein_size", "int"),
    ZINC_MAX_SPAWN_HEIGHT_OVERWORLD("zinc_max_spawn_height_overworld", "int"),

    ENABLE_SERVER_CONFIG_SYNC("enable_server_config_sync", "boolean"),
    SEND_CONFIG_SYNC_PACKET("send_config_sync_packet", "boolean"),

    SPAWN_ZINC_OVERWORLD("spawn_zinc_overworld", "boolean");

    private final String configString;

    private final String valueType;

    BoreConfigValuesList(String configOption, String valueType)
    {
        this.configString = configOption;
        this.valueType = valueType;
    }

    public String getString() {
        return this.configString;
    }

    public String getValueType() {
        return this.valueType;
    }

    public static Collection<String> getAllValues()
    {

        List<String> value_list = Lists.newArrayList();

        for(BoreConfigValuesList configvaluelist : values()) {
            value_list.add(configvaluelist.getString());
        }

        return value_list;

    }
}
