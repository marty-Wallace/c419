package labs.lab6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab6 {

	static String text = "ngisvarkvarkswolfwolvesghghhogelogelsayandsateaxiinateinationisciiscusistliottherialtinaltinallyitiontoruliulusususesejoengoiaahsancesedserssessedasatworstionienateienatwasedienatingienationoneofnespereperespsdondonabledoneddonedlydoneedonerdontimesrsdoningdonmentdonmentsdonsdumetganitionicaltiwastheontistumthrosisticularticulationededlyednessementementsererseshedhbestdlyhednessheshinghlesshlesslyhmenthmentsiaiasicingiofsitardtardizetralableageedementementserersesicingisisedisesjourjoursonororstagetistisedtisestoirtoirstutueureialilecyciescomesyendonosissitialticaltieysysteadyeazzzzzzzzzzstedessssesstccatogadatcytciestnulliustrictstshiptshipszzoeveviatableeviateeviatedeviatelyeviateseviatingeviationeviationseviatoreviatoryeviatorseviatureoachmentssssaulombliriastcablecantcatecatedcatescatingcationcationscativecatortivetorymenmensminaminalminaliaminalianminallyminalsminoanteriorminocardiacminocentesisminocysticminogenitalminohysterectomyminohysterotomyminoposteriorminoscopeminoscopyminothoracicminousminovaginalminovesicalcecedcenscentcentescescingctctedctingctionctionsctorctoresctorsctsranceedaireedaryedariaedarianedariansedariesedariumedariusgegeanceancesancyanciesantghesmoskmosksmusktreedstericithymiadavinedevineduvinenethyrancerancyranciesrantrantlyrantsrateratedratingrationrationalrationsrativeratorrometerroscopeuncateuncatorsesivementmentstaltalstedterterstingtortorsacuationradradsnrynriesnrysnayasekaminablerredrrencerrencesrrencyrrentrrentlyrrerrrersrriblerringrshitealanceancesdenederersesinginglyingnessghncenttatetenetictintineoustinictiteailsailshipeateieusngaoimentitableityitieslatestategenesesgenesisgenesistgeneticgeneticalgeneticallygenygenistgenouslogylogicallogicallysessisticticalticallytrophytrophicritantritateritatedritatingritationritativemalmallymssasalsessinianssobenthonicsolithsopelagicsustonretctctednessctionctionsctivectlyctnessctnessesintdgedgeddgingdicatedicateddicatingdicationdicatorgatenctnctionnctiverationrationsratoryreredrementrerrersresringrirychctatectatedctatingctationqueaterestemicstinstoustetedtestingtiontionstitioustivaltivetivelytivestorututszeezegategatesgationndnessphariapharonpharouspsypsiapticalpticallyssestwhacketsngsnsckomdeententsshtetedtiontionarytionsvionosdalitydalitiesgategatedgatesgatinggationgationsgativegatorgatorsrvaluralrmalrmalcyrmalciesrmalisermalisedrmalisingrmalismrmalistrmalityrmalitiesrmalizermalizedrmalizingrmallyrmalnessrmalsrmityrmitiesrmousmerablerdrdageocketahedementesingadoadosmsdeaudeausdeauxteauteausteauxeteishishableishedisherishersishesishingishmentishmentsitionitionaryitioniseitioniseditionisingitionismitionistitionistsitionizeitionizeditionizingitionslalaeasasaasalasiasumasusasusiinabilityinableinablenessinablyinateinatedinatesinatinginationinationsinatorinatorsinedancenenementadalallyiginalityiginallyiginalsiginaryiginesningsementsivetedtertersticidetienttifacienttintingtiontionaltionisttioniststionstivetivelytivenesstogenictstustuseschementdikroghtlialr";

	public static void main(String[] args) throws FileNotFoundException {
		// This next line just makes the search text longer and more interesting
		// do not modify
		text = lengthen(text);

		List<ISearch> algorithms = new ArrayList<>();
		algorithms.add(new DefaultSearch(""));
		algorithms.add(new BoyerMoore(""));
		algorithms.add(new KMP(""));

		List<String> patterns = new ArrayList<>();

		FileReader f = new FileReader("res/labs/lab6/englishWords.txt");
		Scanner sc = new Scanner(f);

		// This loop runs through the words in the file
		int count = 0;
		while (sc.hasNext()) {
			patterns.add(sc.nextLine());
		}
		System.out.println(patterns.size());
        sc.close();
		for(ISearch algo: algorithms) {
		    count = 0;
			System.out.println("Searching for patterns with " + algo.toString());
			long time = System.currentTimeMillis();
			for(String s: patterns) {
			    algo.setPattern(s);
				if(algo.isIn(text)) {
				    count++;
				}
			}
			time = System.currentTimeMillis() - time;
			System.out.println(algo.toString() + " found " + count + " patterns in " + time + " (ms)");
		}
		/*
            Searching for patterns with String.contains()
            String.contains() found 1095 patterns in 31614 (ms)
            Searching for patterns with BoyerMoore
            BoyerMoore found 1095 patterns in 80422 (ms)
            Searching for patterns with KMP
            KMP found 1095 patterns in 232275 (ms)
		 */
	}


	/**
	 * Do not modify this method. It just creates a large scrambled jumble of a text
	 */
	private static String lengthen(String t) {
		StringBuilder s = new StringBuilder(t);
		for (int j=1; j<=100; j++) {
			for (int i=0; i<t.length(); i++) {
				s.append((char)(j+t.charAt(i)));
			}
		}
		return s.toString();
	}
}
