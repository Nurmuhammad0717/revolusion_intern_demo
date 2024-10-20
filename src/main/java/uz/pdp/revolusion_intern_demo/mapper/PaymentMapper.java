package uz.pdp.revolusion_intern_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import uz.pdp.revolusion_intern_demo.dto.PaymentDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.PaymentCrudDTO;
import uz.pdp.revolusion_intern_demo.entity.Payment;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    PaymentDTO toDto(Payment payment);

    Payment toEntity(PaymentCrudDTO crudDTO);

    List<PaymentDTO> toDto(List<Payment> payments);

    void update(@MappingTarget Payment payment, PaymentCrudDTO crudDTO);

}