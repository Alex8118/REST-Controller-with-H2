package ru.sb.api.accumulation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccumulationService {

    private final AccumulationRepository accumulationRepository;

    public AccumulationService(AccumulationRepository accumulationRepository) {
        this.accumulationRepository = accumulationRepository;
    }

    public Accumulation createAccumulation(Accumulation accumulation) {
        return accumulationRepository.save(accumulation);
    }

    public Page<Accumulation> getAccumulationByOwnerId(int ownerId, Pageable pageable) {
        return accumulationRepository.findByOwnerId(ownerId, pageable);
    }

}
