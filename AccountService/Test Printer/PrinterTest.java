import jpos.*;public class PrinterTest{	//	public static void main(String args[]){		System.out.print("Hello Ballestech");		System.out.print("----------------------------------------------------");		POSPrinterControl114 ptr = (POSPrinterControl114)new POSPrinter();		//		try{			// name of the printer			ptr.open("EPSON");			// for one secand			ptr.claim(1000);			//			ptr.setDeviceEnabled(true);			// print_button			ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT,"Hello From Ballestech Service\n");						//Cancel the device.			ptr.setDeviceEnabled(false);			//Release the device exclusive control right.			ptr.release();			//Finish using the device.			ptr.close();		}catch(JposException ex){					}		System.out.print("-------------------------------------------------------");	}}