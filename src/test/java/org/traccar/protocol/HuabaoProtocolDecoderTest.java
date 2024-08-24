package org.traccar.protocol;

import org.junit.jupiter.api.Test;
import org.traccar.ProtocolTest;
import org.traccar.model.Position;

public class HuabaoProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = inject(new HuabaoProtocolDecoder(null));

        verifyAttribute(decoder, binary(
                "7e0200003a019172511329001300000000000000020158df7206c9607000370000008424051311201801040000000030010d31011d5708000000000000000082020092510201230b7e"),
                Position.PREFIX_TEMP + 1, 29.1);

        verifyAttribute(decoder, binary(
                "7e02000033017051564189000c00000000000c00020158ff7206cd1f4c000000000123201122115639010400000000300143310114930100e3060064019a0000557e"),
                Position.KEY_BATTERY_LEVEL, 100);

        verifyAttribute(decoder, binary(
                "7e020000520198080908740af300000000000c000f016602a302c662f802fc000000cc24051618132401040000020f30011e310109f30100610204b056020acd5d0b0102d40379b8011423033c51108017ffffffffffffffffffffffffffffc87e"),
                Position.PREFIX_TEMP + 1, -2.3);

        verifyAttribute(decoder, binary(
                "7e020000460100503769640002000001000000001a01b9eaf804d8ee86001800000000240507035152010400000000300100310107eb1c00060089fffffffe000400ce0000000c00b28942310221007544309f5f7e"),
                Position.KEY_ICCID, "8942310221007544309");

        verifyAttribute(decoder, binary(
                "7E0200005300959000194400080000000000000003015DA64806CCB4A8001100000000230816014137010400005B3F30011F310112EB29000C00B28986049910219020787400060089FFFFFFFF000600C5FFFFFFEF0004002D0F4E000300A84CE07E"),
                Position.KEY_BATTERY_LEVEL, 76);

        verifyAttribute(decoder, binary(
                "7e55018c418560090010174701022106242122348476113550490700001c06000000074e0000000000000308100000100102020200000a030000000b0803363839363037650c0600000001000afa7e"),
                "unlockResult", 0x65);

        verifyPosition(decoder, binary(
                "7e55018c378580120300032a06052117594022348474113550560705981e0400000002370ac30c0c28660308000000100101020200000a0301cc000c0600a2ffa7ff5e1b7e"));

        verifyPosition(decoder, binary(
                "7e55028c37850011000200c008052106305122348621113550170700001e080000000aaa0000000000000300000000100100020200140a030000000c06003bffa8ffc3c77e"));

        verifyAttribute(decoder, binary(
                "7E020000C2000000001862003F0000000400108042015A322206C869480017007B012E230918081550661D01CC1A0000099DC25727B0130000099DC26B27B00100000C40F89427B0711438393836303436393130323139303037383135336A0114503FF8AF05826BC8CA24E124F732B7C780C5484D6318C0A840412262D4BCEC26CA0234CCB85455D5114F12B650FA841FBEC0B03C67A21F501CAE6C384595028DA76B010060110065000012345678903930303137333833630B0012345678900E5C3080006804000003D46902016F6D7E"),
                Position.KEY_DRIVER_UNIQUE_ID, "\u00909001738");

        verifyAttribute(decoder, binary(
                "7e02000072440061018577001b0000100000200066005ffb8b065dc8900000000000002309080513406316cd91fe1314da1080318122c3a19a6f6f3a0fc6318113660b01fe00000a069a011704de690201a16a011f6b010a6c0f35313031303139313539323738373571143839363231303030313931353932373837353546407e"),
                "lock2Battery", 4.038);

        verifyNull(decoder, binary(
                "7e010200204f07788ef67601824f4459344f544d314d4459774d4441314d444977626d5633553235536457786cba7e"));

        verifyAttribute(decoder, binary(
                "7e0200003f014501643822000300020000000c000c0000000000000000000000000000230615143903300111310100530901027f0300456f073e56020900fe02001e57080002000200000000df7e"),
                Position.KEY_BATTERY_LEVEL, 90);

        verifyAttribute(decoder, binary(
                "7e090000344f07788ef87d0138f02305151230460102020001ffffffff000100001457000000020006503134353700000c000a029dc63004b99a98230515132726787e"),
                Position.KEY_DTCS, "P1457");

        verifyAttribute(decoder, binary(
                "7e0200006476806111898300710000000000100046005d3156065f7128000000000000230511165956660b01fe000001031a5d1a8101670831333231343332326902018b6a01166b01006c0f323034303830393230373533363735711438393434343738383030303030323131303030464b7e"),
                Position.KEY_BATTERY, 3.95);

        verifyAttribute(decoder, binary(
                "7e02000071768060874297002d0000000000208022015a30b006c869f8000000000000230505062034600b0004003930303235343939660b01cc0000000c40f89f27b067083133323134333232690201936a01116b01006c0f34363030383138353937303632343071143839383630343938313032313930353835373430607e"),
                Position.KEY_EVENT, 4);

        verifyAttribute(decoder, binary(
                "7e0200002f017028775424038d000000000000000a0189dbeb04ca653a00000012014723040700074401040000000030011b31010ee1012dea020001dc7e"),
                Position.KEY_BATTERY_LEVEL, 45);

        verifyAttribute(decoder, binary(
                "7E02000079013653183645009E00000000000C0C030158BF0006C926670000004000CE22120904274201040000005DBC3244524956494E47204C4943454E53452454455354244D522E0000000000000000000000000000000000000000000000000000BD0F323431393939393935383030313030E3060000050500007102000C30011F310108987E"),
                "driver", "DRIVING LICENSE$TEST$MR.");

        verifyAttribute(decoder, binary(
                "7e55019c3b8571110003399a07032310302029538631031015370500001a0c000000265700440001233703080000001001020202000a0a04028f000af401040c06ff98ffa8007e707e"),
                "tilt", "[-104,-88,126]");

        verifyPosition(decoder, binary(
                "7e0900001f4f07788ef87d000cf0230223150215010203013800000c000b029dc58c04b99b60230223171822507e"));

        verifyPosition(decoder, binary(
                "7e0200004107904226220608ca0000010000000010031dac0d004864f30000000000002212291003220104000179a7300107310100eb17000300e151000300e304000b00d801041edf340000306b007e"));

        verifyPosition(decoder, binary(
                "7E020000FE069223000241002E00000000000C0003015A98F806C8A1260013000000E622082617464401040000017F02020001030200002504000000002A0200002B0400000000300117310112E306000005890000F3B4000202000000030202F2000402375F00050400000000000602000C000702000C000801320009020072000B020035000C020050000D020176000E0122000F018A00501B4C46504D34414350584731413337303937000000000000000000000052040000000C01000200010101040000000001020200010103040000000101040203E7010C02000E010D020000010E02059B010F020072011002387001110200000112020000011302000001140200000116020000D17E"));

        verifyPositions(decoder, binary(
                "7E021001A2010036526447000A3B00000000000000010158F52206C916B0000000000000161118110121661D019431000B0000CF47006931000B000058A4006930000B0000882400693B00000000000000010158F52206C916B0000000000000161118110122661D019431000B0000CF47006931000B000058A4006930000B0000882400693B00000000000000010158F52206C916B0000000000000161118110123661D019431000B0000CF47006931000B000058A4006930000B0000882400693B00000000000000010158F52206C916B0000000000000161118110124661D019431000B0000CF47006931000B000058A4006930000B0000882400691C00000000000000010158F52206C916B00000000000001611181101253B00000000000000010158F52206C916B0000000000000161118110126661D019431000B0000CF47006931000B000058A4006930000B0000882400693B00000000000000010158F52206C916B0000000000000161118110127661D019431000B0000CF47006931000B000058A4006930000B0000882400691C00000000000000010158F52206C916B0000000000000161118110128F57E"));

        verifyAttribute(decoder, binary(
                "7e02000042012291302260198f00000000800c012300d2651605ff3188001e0000000022102510310003020000a70400000000ac040000012ce5020003e60b03bc572900ce2eef183200e7030000005c7e"),
                Position.PREFIX_TEMP + 3, -17.094117647058823);

        verifyAttribute(decoder, binary(
                "7E0200008201215233475100030000000000000003015A7F6106CF8CEC003D0000000021071311481901040000005630011931011AE10200755D3D0601CC0024990A7dA0032301CC002499099B2941FC01CC002499099B29430B01CC0024990A7dA0290601CC0024990A7dA015FD01CC0026220994506BFFFE157C010400000001F10C000000000000000000000000997E"),
                Position.KEY_ALARM, Position.ALARM_ACCELERATION);

        verifyAttribute(decoder, binary(
                "7e020000340551231425560568000000000400000201618a9706c320e100410000002722060816261501040000015d300115310105eb0a000300e164000300e301957e"),
                Position.KEY_BATTERY_LEVEL, 100);

        verifyNull(decoder, buffer(
                "(794104004140,1,001,BASE,2,TIME)"));

        verifyAttribute(decoder, binary(
                "7E02000053200002604323004800000000000C00000158B91406CB7007006B00000000220512101138010400000F2803020000250400000000300114310100E30100D50E0100026043232795980277530030E50400000000E7020FC8E8020E83AB7E"),
                "lock1Locked", false);

        verifyPosition(decoder, binary(
                "7E0900005A4E5DE66FBA2200C4F02204280610090002010D052B0150052C0400129009052D016B052E014F05300231BA053502000005360203B8053802000005390200AD053D0201EA05440150054604009899D90545040000001E000C00030160A85C06D1C1389C7E"));

        verifyNull(decoder, binary(
                "7E01000021013345678906000F002C012F373031313142534A2D4D3742203030303030303001D4C1423838383838B47E"));

        verifyAttribute(decoder, binary(
                "7E020000480123456789010013000000800000000301597BC506CBFF6600EB00000155210726203531010400000000EB24000C00B28986047701207027150200060089FFFFEFFF0004002D0E10000600C5FFFFFFEF697E"),
                Position.KEY_ALARM, Position.ALARM_LOW_BATTERY);

        verifyAttribute(decoder, binary(
                "7e0200008e01917159043700b300000000800000030158990606ca0fd7000400000000211129111705010400000000cc14383938363037423831303230393031363239363830010d8001aa81021388820200858301148401aa8502189b8601338702007e8801338901148a0200998b1131323334353637383941424344454647488c04000200a88d0200828e0114a00b50353338662c5530323966037e"),
                Position.KEY_DTCS, "P538f U029f");

        verifyPosition(decoder, binary(
                "7E020000830191715904370A2E00000000800000030158991806CA0FEB00040000010D211108194050010400000003CC14383938363034373831303230373033313836303830011A8001AA810213888202007A8301148401AA8502189B8601338702007D028801338901148A0200998B1131323334353637383941424344454647488C04000200A88D0200828E0114A0002E7E"));

        verifyPosition(decoder, binary(
                "7e0200007c0191718447540dcd000000008000000b029eabc204ba78510004000000042111182321120104000017f6cc14383933303237323037303339333033383732373130011d800134810204718202008283010e84017b85021ae986012f870201788901038b114a4e31424a314352364b573333363533358c040008dcb68d02018c8e013da000c07e"));

        verifyNotNull(decoder, binary(
                "7e207002940121523001530047210927151009000e002d80ac210927151010000e002d80ab210927151011000e002d80ac210927151012000e002e80ab210927151013000e002d80ab210927151014000e002d80ab210927151015000e002d80ab210927151016000e002d80aa210927151017000e002e80ab210927151018000e002d80ab210927151019000e002e80ac210927151020000e002d80ab210927151021000e002d80ab210927151022000d002d80ac210927151023000e002d80ac210927151024000e002e80ab210927151025000e002e80b0210927151026000e002e80ab210927151027000e002d80ab210927151028000e002e80b0210927151029000e002d80b0210927151030000e002e80ab210927151031000e002d80ab210927151032000e002d80aa210927151033000e002d80ab210927151034000e002d80ab210927151035000e002d80ab210927151036000e002d80ab210927151037000e002d80ab210927151038000e002d80b0210927151039000d002e80aa210927151040000e002d80ab210927151041000e002d80a5210927151042000e002e80ab210927151043000e002d80aa210927151044000e002d80ab210927151045000e002d80ab210927151046000e002d80ac210927151047000e002e80ab210927151048000e002e80a5210927151049000e002d80ab210927151050000e002d80ab210927151051000e002d80ab210927151052000e002d80ab210927151053000e002d80aa210927151054000e002e80b0210927151055000e002e80ab210927151056000e002d80ac210927151057000e002e80ab210927151058000e002d80ab210927151059000e002e80ab210927151100000e002d80ab210927151101000e002e80aa210927151102000e002d80a6210927151103000e002e80a5847e"));

        verifyNotNull(decoder, binary(
                "7e07040226046110426684002b000601005f0000000000000000000000000000000000000000000021031410530001040000000030011b310101e4020064e50101e60100e7080000000000000000eb2101cc00253510260100000000000000000000000000000000000000000000000000005f00000000004c0001000000000000000000000000000021031410531401040000000030011f310103e4020064e50101e60100e7080000000000000000eb2101cc0025351026012535100f32263d11f931000000000000000000000000000000005f00000000004c0001000000000000000000000000000021031410534001040000000030011f310104e4020064e50101e60100e7080000000000000000eb2101cc002535102601263d11f92d0000000000000000000000000000000000000000005f00000000004c00010000000000000000000000000000210314105350010400000000300118310104e4020064e50101e60100e7080000000000000000eb2101cc002535102601263d11f92e25350f6f2c263d120d2c00000000000000000000005f00000000004c0001000000000000000000000000000021031410540001040000000030011d310105e4020064e50101e60100e7080000000000000000eb2101cc002535102601263d11f93025350f6f2e263d120d2e00000000000000000000003c00000000004c0003015ae3e106c82ab900000010010b21031410540901040000000030011b310105e4020064e50101e60100e7080000000000000000f97e"));

        verifyAttribute(decoder, binary(
                "7e02000033421030000018004c000200000004000201556dcb06c4d41d000c00f100fc210118095853010400000000fe0140ff0c01cc000000002694000055d87a7e"),
                Position.KEY_ALARM, Position.ALARM_TAMPERING);

        verifyAttribute(decoder, binary(
                "7e02000033202011200010001300020000000400020158b30006c93ee5002000000000201127162937010400000000fe0145ff0c01cc00000000263300000f3e627e"),
                Position.KEY_BATTERY_LEVEL, 69);

        verifyPosition(decoder, binary(
                "7e0200002e202000129707001c0000000000001c0601a2f0a8091f0bf00000000000ed201103031733000000000000000000780000000018000000267e"));

        verifyAttribute(decoder, binary(
                "7e070400db07904116875014480003010046000000000000000b020057d40072fb9c0064017200f220090215230301040000092930011f31010ceb1c000c00b28921200272401241734f00060089ffffffef000400ce1d460046000000000000000b0200570c0072fdb2005f013600ee20090215230801040000092a30011f31010ceb1c000c00b28921200272401241734f00060089ffffffef000400ce1e800046000000000000000b020056ac0072fe9b005a00d200ec20090215231301040000092a30011b31010ceb1c000c00b28921200272401241734f00060089ffffffef000400ce1e35d77e"),
                Position.KEY_POWER, 74.94);

        verifyAttribute(decoder, binary(
                "7e550104337401903111850622072002454206133574075359513a0000080100000001aa00005ded05e203000000000c06005affb5ffb40a0302dc65100100137e"),
                Position.KEY_CHARGE, true);

        verifyAttribute(decoder, binary(
                "283734303139303331313138352c312c3030312c454c4f434b2c332c35323934333929"),
                Position.KEY_RESULT, "(740190311185,1,001,ELOCK,3,529439)");

        verifyPosition(decoder, binary(
                "7e55028436740190311185091607200239270613212607536108630000170a000000014600005ded05e203000000000b010d0c06005b003e00ab0a0302dc65100100a37e"));

        verifyPosition(decoder, binary(
                "7E550100287001608180000127061008045322332880113555602E050031010000000608000010931435010002000300030100051B7E"));

        verifyAttribute(decoder, binary(
                "7E0200005C03204187290418C70000000000040003015AFC8D06D134D600000000000020040110063457080000000000000000010400000002530901000000000000000030010F310106EB1D000800233030312E3437000A000300000000000000000005000101A500357E"),
                "fuel2", 1.47);

        verifyAttribute(decoder, binary(
                "7E0200005C087034547007000B0000000000040003015A7CEF06CF8A84000000000000200108064451570800000000000000000104000000005309010000000000000000300113310109EB1D000800233030302E3838000A0003001A00000000000000050001037700B27E"),
                "fuel1", 88.7);

        verifyAttribute(decoder, binary(
                "7e02000054086031592715006e0000000000000002015a3c1a06c8733800000000000019103022183633362a4d30302c34352c31313338363030526f79314f70656e26303030303030303030303030263132333435363738393031323334353623ff7e"),
                Position.KEY_BATTERY, 3.86);

        verifyPosition(decoder, binary(
                "7e0200004e08026300003006480000000000000007021477d90841920700000000005019110515194001040000167130011631010cd00400000400d3020027d4013fd6143839363130313832303030343833363532383330da0104897e"));

        verifyPosition(decoder, binary(
                "7e020000400303000002280042000000000000000301618ab406c31ec800000000000518092116145701040000047830011031010aeb16000c00b28986011780108622216500060089ffffffffc37e"));

        verifyPosition(decoder, binary(
                "7E0200002A013833501744001900000000000000C201597FA806CC01580080000000081508180721210104000002F502020000030200009F7E"));

        verifyPositions(decoder, binary(
                "7E0704014301356777777707F5000801002600000000000000030159741206CBFD5001720000000116052709062401040000001D03020000002600000000000000030159746606CBFD50016B0000000116052709065301040000001D0302000000260000000000000003015975E406CBFE58013F0000000116052709072701040000001D0302000000260000000000000003015976DE06CBFF10012E0000000116052709075601040000001D0302000000260000000000000003015976BC06CBFED0012D0000000116052709083001040000001D0302000000260000000000000003015976FE06CBFEC001080000000116052709090001040000001D0302000000260000000000000003015976FE06CBFE7800FC0000000116052709093301040000001D0302000000260000000000000003015977A606CBFF3001080000000116052709100201040000001D030200001F7E"));

        verifyAttributes(decoder, binary(
                "7E0200002F01357888888800B60000000000000003015972B406CBF6B802230000000116061317571301040000000003020000EB0700050001016708B37E"));

        verifyPositions(decoder, binary(
                "7E070400F30303000002450064000401003A000000000000000301618AC606C31F20000000000029180514202847010400000000EB16000C00B28986061708003732585700060089FFFFFFFE003A000000000000000301618AE806C31EB800000000009F180514202917010400000000EB16000C00B28986061708003732585700060089FFFFFFFE003A000000000000000301618AE806C31EB800000000009F180514202947010400000000EB16000C00B28986061708003732585700060089FFFFFFFE003A000001000000080301618AE806C31EB800000000009F180514203006010400000000EB16000C00B28986061708003732585700060089FFFFFFFED77E"));

        verifyPosition(decoder, binary(
                "7e02000054093037612710000700000000000000010223aca000dc9dd800000000000017121417122133362a4d30302c34352c31313336393042383030313233303026303030303030303030303030263132333435363738393031323334353623897e"));

        verifyPosition(decoder, binary(
                "7e0200002c00160128561400020000000000040001005de1f7065c6cef00000000000017011710044201040000a9002a02000030011b3101030c7e"));

        verifyPosition(decoder, binary(
                "7e0200002c00160128561400030000000000040007005de13c065c6cdb00160000000017011710054201040000a9002a02000030011b310104e47e"));

        verifyNull(decoder, binary(
                "7e0100002d0141305678720024002c012f373031313142534a2d41362d424400000000000000000000003035363738373201d4c14238383838386d7e"));

        verifyNull(decoder, binary(
                "7E0100002D013511221122000500000000373031303748422D52303347424400000000000000000000003233363631303402CBD5424136383630387E"));

        verifyNull(decoder, binary(
                "7e0100002d007089994489002800000000000000000048422d523033474244000000000000000000000031393036373531024142433030303030d17e"));

        verifyNull(decoder, binary(
                "7E0102000E013511221122000661757468656E7469636174696F6E3F7E"));

        verifyPosition(decoder, binary(
                "7E02000032013511221122000700000000000C000301578CC006CA3A5C00470000000014072317201501040000000030011631010BD07E"));

        verifyNull(decoder, binary(
                "7E010200100940278494700084323031313131303831313333323139369F7E"));

        verifyNull(decoder, binary(
                "7e010000190940278494700012000000000000000000000000000000000000094027849470000a7e"));

        verifyPosition(decoder, binary(
                "7e0200002e094027587492000a000000010000000a03083db7001329f3000000140000130412164952010400000012360a0002341502cb0c20085c107e"));

        verifyPosition(decoder, binary(
                "7e020000220014012499170007000000000000400e012af16f02cbd2ba000000000000150101194257010400000077a97e"));

        verifyNull(decoder, binary(
                "7e0002000004304832546500b7ca7e"));

        verifyAttribute(decoder, binary(
                "7E020000964130564801050048000000001000004F01651E2E02CAEC3802E80000001524062616002101040000000330011F31010EF1040000308CF231414F56585F564C3330302D4C415F48322E315F4547393135554C4141425230334130324D30385F56322E312E305F763130F3011FF400F5080000000000000001F6084008FFFFFFFD0009F70600000E870246F912000F000000010000062A00082406261600184D7E"),
                Position.KEY_CHARGE, true);

        verifyAttribute(decoder, binary(
                "7E020000964130564801050048000000001000004F01651E2E02CAEC3802E80000001524062616002101040000000330011F31010EF1040000308CF231414F56585F564C3330302D4C415F48322E315F4547393135554C4141425230334130324D30385F56322E312E305F763130F3011FF400F5080000000000000001F6084008FFFFFFFD0009F70600000E870246F912000F000000010000062A00082406261600184D7E"),
                Position.KEY_POWER, 12.428);

    }

}
