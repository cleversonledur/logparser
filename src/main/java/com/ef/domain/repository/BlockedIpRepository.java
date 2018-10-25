package com.ef.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.ef.domain.model.BlockedIp;

public interface BlockedIpRepository extends CrudRepository<BlockedIp, Integer> {
}
