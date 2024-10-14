package uz.pdp.revolusion_intern_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.revolusion_intern_demo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}