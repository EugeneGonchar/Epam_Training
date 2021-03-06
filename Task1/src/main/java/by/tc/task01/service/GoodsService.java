package by.tc.task01.service;

import by.tc.task01.entity.Goods;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.service_exception.FindingGoodsFailedException;
import java.util.List;

public interface GoodsService {
    <E> List<Goods> find(Criteria<E> criteria) throws FindingGoodsFailedException;
}
