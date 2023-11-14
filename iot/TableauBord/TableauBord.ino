/***********************************************************************************
 Send board information each second
 
 Configuration below :                                                             */
#define GENERAL_CUT_PIN 2;


struct GeneralCutOff {
  unsigned int pin=GENERAL_CUT_PIN;
  boolean isOn=false;
};

struct Result {
  unsigned long timeStamp=0;
  unsigned int period=1000;
};


/***********************************************************************************
  GeneralCutOff
************************************************************************************/
struct GeneralCutOff generalCutOff;

bool isGeneralCutButtonPushed(GeneralCutOff generalCutOff) {
  return digitalRead(generalCutOff.pin) == 0;
}

bool isGeneralCutOn(GeneralCutOff generalCutOff) {
  return generalCutOff.isOn;
}

void switchGeneralCutButton(GeneralCutOff *generalCutOff) {
  ( generalCutOff->isOn ) ? generalCutOff->isOn=false : generalCutOff->isOn= true;
}


/***********************************************************************************
  Result
************************************************************************************/
struct Result result;

bool isItTimeToSendResult(Result *result) {
  if (millis() - result->timeStamp > result->period) {
    result->timeStamp+=result->period;
    return true;
  } else {
    return false;
  }
}

void sendResult(GeneralCutOff generalCutOff) {
  Serial.print(isGeneralCutButtonPushed(generalCutOff));
    Serial.print(generalCutOff.isOn ? "1" : "0");
    Serial.println();
}


/***********************************************************************************
  setup
***********************************************************************************/
void setup() {
  Serial.begin(9600);

  pinMode(generalCutOff.pin, INPUT_PULLUP);


  Serial.println("## Board setup");

  Serial.print("##  - send result period : ");
  Serial.print(result.period);
  Serial.println(" ms");

  Serial.print("##  - genenral cut off : ");
  Serial.println(generalCutOff.pin);
}


/***********************************************************************************
  loop
***********************************************************************************/
void loop() {
  if( isGeneralCutButtonPushed(generalCutOff) ) {
    if ( !isGeneralCutOn(generalCutOff) ) switchGeneralCutButton(&generalCutOff);
  } else {
    if( isGeneralCutOn(generalCutOff) ) { switchGeneralCutButton(&generalCutOff);
  }

  if( isItTimeToSendResult(&result) ) {
    sendResult(generalCutOff);
  }

}
