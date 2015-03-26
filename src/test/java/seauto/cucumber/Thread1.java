/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */

package seauto.cucumber;

import org.junit.runner.RunWith;

import com.partnet.SeAutoCucumber;

import cucumber.api.CucumberOptions;


@RunWith(SeAutoCucumber.class)
@CucumberOptions(features = {"classpath:features/threadExample/"})
public class Thread1 {
}