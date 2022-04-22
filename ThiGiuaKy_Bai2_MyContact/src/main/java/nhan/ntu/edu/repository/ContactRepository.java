package nhan.ntu.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nhan.ntu.edu.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	 //Custom query
	 @Query(value = "SELECT * FROM contacts c WHERE c.name like %:keyword% or c.email like %:keyword% or c.phone like %:keyword% or c.facebook like %:keyword% ", nativeQuery = true)
	 List<Contact> findByKeyword(@Param("keyword") String keyword);
}
