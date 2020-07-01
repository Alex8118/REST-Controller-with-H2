package ru.sb.api.accumulation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static ru.sb.api.common.Constants.API_PATH;

@RestController
@RequestMapping(API_PATH + "/accumulation")
@ControllerAdvice
public class AccumulationController {

    private final AccumulationService accumulationService;
    private final AccumulationMapper accumulationMapper;

    public AccumulationController(AccumulationService accumulationService, AccumulationMapper accumulationMapper) {
        this.accumulationService = accumulationService;
        this.accumulationMapper = accumulationMapper;
    }


    @GetMapping
    public Page<AccumulationDto> getByOwnerId(
            @PageableDefault(size = 10, page = 0) Pageable pageable,
            @RequestParam Integer ownerId) {
        return accumulationService.getAccumulationByOwnerId(ownerId, pageable)
                .map(accumulation -> accumulationMapper.fromAccumulation(accumulation));
    }

   @PostMapping
    public AccumulationDto create(
            @Valid @RequestBody AccumulationDto accumulationDto
    ) {
        var accumulation = accumulationMapper
                .toAccumulation(accumulationDto);
        return accumulationMapper.fromAccumulation(
                accumulationService.createAccumulation(accumulation)
        );
    }


}
