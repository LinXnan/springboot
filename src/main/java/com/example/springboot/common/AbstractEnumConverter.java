package com.example.springboot.common;

import javax.persistence.AttributeConverter;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2019-12-25 下午 06:38
 */
public abstract class AbstractEnumConverter<ATTR extends Enum<ATTR> & PersistEnum2DB<DB>, DB> implements AttributeConverter<ATTR, DB> {

    private final Class<ATTR> clazz;

    public AbstractEnumConverter(Class<ATTR> clazz) {
        this.clazz = clazz;
    }

    @Override
    public DB convertToDatabaseColumn(ATTR attribute) {
        return attribute != null ? attribute.getData() : null;
    }

    @Override
    public ATTR convertToEntityAttribute(DB dbData) {
        if (dbData == null) return null;

        ATTR[] enums = clazz.getEnumConstants();

        for (ATTR e : enums) {
            if (e.getData().equals(dbData)) {
                return e;
            }
        }

        throw new UnsupportedOperationException("枚举转化异常。枚举【" + clazz.getSimpleName() + "】,数据库库中的值为：【" + dbData + "】");
    }

}
