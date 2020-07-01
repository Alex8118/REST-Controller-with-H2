package ru.sb.api.accumulation;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccumulationMapper {

    AccumulationDto fromAccumulation(Accumulation source);

    @InheritInverseConfiguration
    Accumulation toAccumulation(AccumulationDto target);

}
