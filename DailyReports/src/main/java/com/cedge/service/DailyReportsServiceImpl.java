package com.cedge.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedge.entity.ADB;
import com.cedge.entity.DailyReports;
import com.cedge.repo.ADBRepo;
import com.cedge.repo.DailyReportsRepo;

@Service
public class DailyReportsServiceImpl implements DailyReportsService {
	
	@Autowired
	private ADBRepo adbRepo;
	
	@Autowired
	private DailyReportsRepo drRepo;

	@Override
	public List<ADB> getListOfRecords(LocalDate yesterday) {
		List<ADB> ListbyDate = adbRepo.findByDate(yesterday);
		if (ListbyDate != null)
			return ListbyDate;
		
		return null;
	}

	@Override
	public Map<String,Long> getSucesscount(List<ADB> list) {
		Map<String, Long> collect = list.stream().filter(e -> e.getMessage()!=null && "success".equalsIgnoreCase(e.getMessage().trim())).collect(Collectors.groupingBy(b -> b.getBank(),Collectors.counting()));
		return collect;
	}

	@Override
	public Map<String,Long> getUnsucesscount(List<ADB> list) {
		Map<String, Long> collect = list.stream().filter(e -> e.getMessage()!=null && !"success".equalsIgnoreCase(e.getMessage().trim())).collect(Collectors.groupingBy(b -> b.getBank(),Collectors.counting()));
		return collect;
	}

	@Override
	public boolean InsertIntoDailyReports(List<ADB> list,  Map<String, Long> sucessMap,  Map<String, Long> unsucessMap, LocalDate date) {
		boolean flag = false;
		for (String bank : sucessMap.keySet()) { 
			System.out.println(bank); //1 HDFC  2 SBI 
			int sucess = sucessMap.get(bank).intValue(); // 5 //15 
			int failed = unsucessMap.getOrDefault(bank, 0L).intValue(); //5  // 5
			System.out.println(sucess +" --- " + failed);
			
			DailyReports dr = new DailyReports();
			dr.setBank(bank);
			dr.setSuccessful(sucess);
			dr.setUnsuccessful(failed);
			dr.setDate(date);
			
			DailyReports save = drRepo.save(dr);
			flag = true;
			
		}
		
		return flag;
		
	}

	
	

}
