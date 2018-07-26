package com.example.base.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.base.model.Demo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator.Feature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@RequestMapping("/csv")
@RestController
public class CsvController {

	@GetMapping(value = "*.csv", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
			+ "; charset=Shift_JIS; Content-Disposition: attachment")
	@ResponseBody
	public Object getCsv() throws JsonProcessingException {
		List<Demo> demos = new ArrayList<Demo>() {
			{
				add(new Demo(1001L, "aaa", "xxx", new Date()));
				add(new Demo(1002L, "bbb", "yyy", new Date()));
				add(new Demo(1003L, "ccc", "zzz", new Date()));
			}
		};

		CsvMapper mapper = new CsvMapper();
		mapper.configure(Feature.ALWAYS_QUOTE_STRINGS, true);
		CsvSchema schema = mapper.schemaFor(Demo.class).withHeader().withLineSeparator("\r\n").withColumnSeparator(',').withEscapeChar('"').withQuoteChar('"');
		
		return mapper.writer(schema).writeValueAsString(demos);
	}
	
	
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public Object download(HttpServletResponse response) throws IOException {
	    response.addHeader("Content-Type", "application/octet-stream");
	    response.addHeader("Content-Disposition", "attachment; filename*=UTF-8''" + "20121201-12323123_20191101112233.csv");
	    return getCsv();
	}
}
