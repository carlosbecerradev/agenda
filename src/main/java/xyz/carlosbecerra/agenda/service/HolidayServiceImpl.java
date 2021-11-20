package xyz.carlosbecerra.agenda.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.carlosbecerra.agenda.dao.JpaHolidayRepository;
import xyz.carlosbecerra.agenda.entity.Holiday;

@Service
@AllArgsConstructor
public class HolidayServiceImpl implements IHolidayService {

	private final JpaHolidayRepository holidayRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Holiday> findAll() {
		return holidayRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Holiday findById(Long holidayId) {
		// TODO Auto-generated method stub
		return holidayRepository.findById(holidayId).orElse(new Holiday());
	}

	@Override
	@Transactional
	public void insert(Holiday holiday) {
		holidayRepository.save(holiday);
	}

	@Override
	@Transactional
	public void update(Holiday holiday) {
		holidayRepository.save(holiday);
	}

	@Override
	@Transactional
	public void deleteById(Long holidayId) {
		holidayRepository.deleteById(holidayId);
	}

}
