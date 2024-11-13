/*
 * @ {#} SkillLevelConverter.java   1.0     13/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.backend.models.SkillLevel;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   13/11/2024
 * @version:    1.0
 */
@Converter(autoApply = true)
public class SkillLevelConverter implements AttributeConverter<SkillLevel, Byte> {

    @Override
    public Byte convertToDatabaseColumn(SkillLevel skillLevel) {
        return (skillLevel!=null) ? skillLevel.getLevel() : null;
    }

    @Override
    public SkillLevel convertToEntityAttribute(Byte level) {
        return (level!=null) ? SkillLevel.fromByte(level) : null;
    }
}
