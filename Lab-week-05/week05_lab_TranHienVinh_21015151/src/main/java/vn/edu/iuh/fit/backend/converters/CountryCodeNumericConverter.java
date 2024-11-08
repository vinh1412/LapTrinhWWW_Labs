/*
 * @ {#} CountryCodeNumericConverter.java   1.0     06/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.converters;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   06/11/2024
 * @version:    1.0
 */
@Converter(autoApply = true)
public class CountryCodeNumericConverter implements AttributeConverter<CountryCode, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CountryCode countryCode) {
        return countryCode != null ? countryCode.getNumeric(): null;
    }

    @Override
    public CountryCode convertToEntityAttribute(Integer integer) {
        return integer != null ? CountryCode.getByCode(integer): null;
    }
}
