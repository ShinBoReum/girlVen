package com.girlvengers.gvc.service;

import com.girlvengers.gvc.mapper.CSVMapper;
import com.girlvengers.gvc.vo.CSVVo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CSVService {

    @Autowired
    public CSVMapper mapper;

    @PostConstruct
    public void readCSV(){
        loadDataFromCSV("D:\\workspace\\gvc\\src\\main\\java\\com\\girlvengers\\gvc\\service\\rateData.csv");
    }

    public int saveAll(List<CSVVo> rateData) {
        return mapper.saveAll(rateData);
    }
    public List<CSVVo> selectRateList(){
        return mapper.selectRateList();
    }

    @Transactional
    public void loadDataFromCSV(String fileName) {
        try {
            // fileName 기준으로 파일을 가져온 후, FileReader 변환 -> 이걸 다시 CSVReader로 변환
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            CSVReader csvReader = new CSVReader(reader);

            //csvReader.readNext(); // 도, 시 한 줄 생략
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {

                // contents list 구축
                List<String> contentsList = ContentsList(nextRecord);


            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> ContentsList(String [] line){

        List<String> contentsList;

        // contents list 구축
        contentsList = new ArrayList<String>();

        for(int i=0; i<9; i++) {
            if(!line[i].equals("")) {

                contentsList.add(line[i]);

            } else {
                continue;
            }
        }
        System.out.println(contentsList);
        return contentsList;
    }


}
