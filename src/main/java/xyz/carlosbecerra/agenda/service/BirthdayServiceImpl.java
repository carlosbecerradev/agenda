package xyz.carlosbecerra.agenda.service;

import java.time.LocalDate;
import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.carlosbecerra.agenda.dao.JpaBirthdayRepository;
import xyz.carlosbecerra.agenda.entity.Birthday;

@Service
@AllArgsConstructor
public class BirthdayServiceImpl implements IBirthdayService {

	private JpaBirthdayRepository birthdayRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Birthday> findALl() {
		return birthdayRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Birthday findById(Long birthdayId) {
		return birthdayRepository.findById(birthdayId).orElse(new Birthday());
	}

	@Override
	@Transactional
	public void insert(Birthday birthday) {
		birthdayRepository.save(birthday);
	}

	@Override
	@Transactional
	public void update(Birthday birthday) {
		birthdayRepository.save(birthday);
	}

	@Override
	@Transactional
	public void deleteById(Long birthdayId) {
		birthdayRepository.deleteById(birthdayId);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Birthday> findByStartDate(LocalDate startDate) {
		return birthdayRepository.findByDayAndMonth((byte) startDate.getDayOfMonth(), (byte) startDate.getMonthValue());
	}

}
