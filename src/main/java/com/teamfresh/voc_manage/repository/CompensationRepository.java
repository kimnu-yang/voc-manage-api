package com.teamfresh.voc_manage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.teamfresh.voc_manage.model.Compensation;
import com.teamfresh.voc_manage.model.response.CompensationResponse;

public interface CompensationRepository extends JpaRepository<Compensation, Long> {

    Compensation save(Compensation compensation);

    Optional<Compensation> findById(Long compensation_id);

    @Query(value = ""+
    "SELECT c.id, v.id vocId, v.delivery_id deliveryId, v.arisen_from arisenFrom, c.detail, c.reg_date regDate, c.amount " + //
    "FROM compensation c " + //
    "JOIN voc v on c.voc_id = v.id"
    , nativeQuery = true)
    List<CompensationResponse> findForCompensationList();
}
