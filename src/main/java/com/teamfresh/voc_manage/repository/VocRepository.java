package com.teamfresh.voc_manage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.teamfresh.voc_manage.model.Voc;
import com.teamfresh.voc_manage.model.response.VocResponse;

public interface VocRepository extends JpaRepository<Voc, Long> {

    Voc save(Voc voc);
    
    Optional<Voc> findById(Long id);

    @Query(value = ""+
    "SELECT v.id, d.id deliveryId, cl.id clientId, w.id workerId, t.id transportId, " + //
    "v.reason, v.arisen_from arisenFrom, v.reg_date regDate, cp.detail compensationDetail, cp.amount compensationAmount, p.fine, p.confirm workerConfirm " + //
    "FROM Voc v " + //
    "JOIN delivery d on v.delivery_id = d.id " + //
    "JOIN client cl on d.client_id = cl.id " + //
    "JOIN worker w on d.worker_id = w.id " + //
    "JOIN transport t on w.transport_id = t.id " + //
    "LEFT JOIN compensation cp on cp.voc_id = v.id " + //
    "LEFT JOIN penalty p on p.compensation_id = cp.id"
    , nativeQuery = true)
    List<VocResponse> findForVocList();
}