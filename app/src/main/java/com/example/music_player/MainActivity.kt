package com.example.music_player

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var arraysong: ArrayList<OutData>
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AddSong()
        val adapter = RvAdapter(arraysong, object : Rvinterface {
            override fun Onclickmusic(pos: Int) {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                val bundle = Bundle()
                intent.putExtra("arraysong", arraysong)
                bundle.putInt("position", pos)
                bundle.putString("txtsn", arraysong[pos].title)
                bundle.putString("txtsinger", arraysong[pos].casi)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        })

        findViewById<RecyclerView>(R.id.rvsong).adapter = adapter
        findViewById<RecyclerView>(R.id.rvsong).layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
    }
    private fun AddSong() {
        arraysong = arrayListOf()
        arraysong.add(OutData( "À-Lôi", "Double2T-Masew", R.raw.aloi,"Tại vì thích em nhiều quá nhưng em lại nói là \"à lôi\"\n" +
                "Cũng định solo hiphop cùng với trai bản nhưng mà thôi \n" + "Anh gửi vào trong câu rap cho em dính cả thính cả mồi\n" + "Nhà em có mấy quả đồi ừ thì anh cũng tính cả rồi\n" + "\n" + "Tại vì thích em nhiều quá nhưng em lại nói là \"à lôi\" \n" + "Cũng định solo hiphop cùng với trai bản nhưng mà thôi \n" + "Anh gửi vào trong câu rap cho em dính cả thính cả mồi\n" + "Nhà em có tới mấy quả đồi ừ thì anh cũng tính cả rồi\n" + "\n" + "\n" + "Gặp em ở thung lũng ném quả còn lên không trung \n" + "Anh bận đi tìm cảm hứng trong chuỗi ngày bị mông lung \n" +
                "Anh cầm trên tay cây nỏ, ngắm vào tâm nhưng không trúng\n" + "Nhưng mà lỡ bị em gây thương nhớ, bắn vào tim mà không súng \n" + "\n" + "Trai bản em chơi đàn tính còn anh thì gẩy guitar\n" + "Anh thì không biết múa khèn nhưng mà giỏi quẩy vina \n" +
                "Yêu em mấy núi cũng trèo mặc dù không giỏi đi xa\n" + "Anh lại còn giỏi cả thi ca biến homestay bản thành villa\n" + "\n" + "Tấm lòng anh không phải thú dữ ko cần mổ bụng thì mới được xem \n" + "Mấy anh thanh niên trong bản phải biết uống rượu mới tán được em \n" + "Nhà sàn của em sẵn bậc, nhưng nàng đồng ý mới có đường lên \n" +
                "Anh thì số vốn đen đủi không biết lần này liệu có được hên\n" + "\n" + "Ừ thì noọng ơi, à lôi \n" + "Hai chúng mình thì cùng đẹp nết, đẹp cả đôi\n" + "Hội trai bản để anh dẹp hết, chấp cả hội\n" + "Trồng cây kín cả quả đồi, xong dắt em đi về nhà thôi \n" + "\n" + "Ơi nọong ơiii\n" + "\n" + "Thương em mấy núi cũng trèo, mấy sông cũng lội mấy đèo cũng qua\n" + "\n" + "Nhà em ở ngay lưng đồi, nếu như có dịp mời chàng tới chơi\n" + "\n" + "\n" + "Tại vì thích em nhiều quá nhưng em lại nói là \"à lôi\"\n" + "Cũng định solo hiphop cùng với trai bản nhưng mà thôi\n" + "Anh gửi vào trong câu rap cho em dính cả thính cả mồi\n" + "Nhà em có mấy quả đồi ừ thì anh cũng tính cả rồi\n" + "\n" +
                " \n" + "Một hai ba yeh nơng thoong tham \n" + "Đây là người miền núi phía Bắc Việt Nam\n" + "Hiên ngang không thích luồn cúi\n" + "Flexing theo kiểu miền núi\n" +
                "(Flex flex)\n" + "\n" + "Ta chơi nhạc trap, hiphop trên bản làng\n" + "Bản này là bản chất, biến từ đất thành bản vàng\n" + "Từ những ngày khó khăn, các dân tộc còn tản mạn\n" + "Đến ngày chung tay cùng làm kinh tế, tiền chất đống như tải hàng\n" + "\n" + "Và ta đi lên từ bàn tay trắng (từ bàn tay trắng)\n" + "Cần cù chịu khó, không nhờ may mắn (không nhờ may mắn)\n" + "Trải qua khó khăn một mưa hai nắng (một mưa hai nắng)\n" + "Người biết khiêm tốn là người hay thắng\n" + "(Prrrrr)"))
        arraysong.add(OutData( "Cho Tôi Lang Thang", "Ngo-Đen", R.raw.chotoilangthang,"Nơi nhân gian sum vầy\n" +
                "Em có nghe thấy\n" + "Tiếng réo gọi tâm hồn\n" + "Ngân vang đâu đây\n" + "\n" + "[Verse 1: Đen]\n" + "Ngày lang thang\n" + "Trong cơn mơ\n" + "Không veston không cà vạt\n" + "Không nhiều Than Thở, dẫu mình hay mơ về Đà Lạt\n" + "Đi cho vai áo bạc màu\n" + "Những hành trình dài\n" + "Để khi ta thay áo mới\n" +
                "Nhìn lại đã thành hình hài\n" + "\n" + "Và không có đường nào khó\n" + "Chỉ có chân ngại lối xa\n" + "Cuối con đường dần ló mặt trời lên\n" + "Xua màn tối qua\n" + "Nắng ươm ta màu đời\n" +
                "Mai ta mọc thành cây cao\n" + "Và khi gió ru ca cội nguồn, ôi mình hôm qua đây sao?\n" + "Vẫn bước đi, cười trên môi, làm giấy thông hành\n" + "Gói gém câu ca vào trong hành trang\n" + "Vì thiếu nó thấy không đành\n" +
                "Chất thêm chút bình yên\n" + "Gói lại bằng tình duyên\n" + "Ta đi tìm mắt bão đời\n" + "Vì trong cơn bão mới nhẹ lòng, mình yên\n" + "\n" + "Cho riêng ta lang thang thôi\n" + "Để nhạc đời không lạc điệu\n" + "Lòng người sâu vời\n" +
                "Như bầu trời, ai đo đạc, liệu?\n" + "Xa bao nhiêu\n" + "Giữa con đường vắng nắng tan hoang\n" + "Và ngày nào còn khát\n" + "Thì ngày đó ta còn lang thang\n" + "\n" + "[Chorus: Ngọt]\n" + "Nơi nhân gian sum vầy\n" + "Em có nghe thấy\n" + "Tiếng réo gọi tâm hồn\n" + "Ngân vang đâu đây\n" + "\n" + "[Verse 2: Đen]\n" + "Nếu em hỏi cho đến bây giờ\n" + "Tại sao anh vẫn lông bông?\n" + "\"Vì anh muốn khoác bụi lên mình\n" + "Cho tâm hồn đỡ tồng ngồng\"\n" + "Vì cuộc đời này công bằng\n" + "Cũng chỉ một lần để sống\n" + "Người ta mơ nhà mơ cửa\n" + "Còn anh mơ núi mơ sông\n" + "\n" + "Rồi cũng sẽ đến một ngày tóc\n" + "Như mây mờ trắng xoá\n" + "Rồi sẽ tiếc khi trở về già\n" + "Tuổi đời bây giờ ngắn quá\n" + "Thanh xuân ngủ vùi chăn ấm\n" + "Đời như mãi mùa đông\n" + "Nên anh trải đời trong nắng gió\n" + "Như con thú hoang sổ lồng\n" + "\n" + "Đường nào đi được hết?\n" + "Trán nào còn nhăn mãi?\n" + "Muốn cùng em hút chung điếu thuốc\n" + "Để khói mù cả Căng Chải\n" + "Vì đất nước mình còn lạ\n" + "Cần chi đâu nước ngoài\n" + "Đặt chân lên tất cả mọi miền\n" + "Là ước mơ ta ước hoài\n" + "\n" + "Chẳng cho mình là lãng tử\n" + "Đã đi được mấy đâu\n" + "Chẳng cho mình là nghệ sĩ\n" + "Đã viết được mấy câu\n" + "Chẳng tự do đến mức buông lơi như DSK\n" + "Nhưng nếu một ngày đôi chân ngừng lại\n" + "Thì thà anh đi chết ngay\n" + "\n" + "[Chorus: Ngọt]\n" + "Nơi nhân gian sum vầy\n" + "Em có nghe thấy\n" + "Tiếng réo gọi tâm hồn\n" + "Ngân vang đâu đây\n" + "\n" + "Nơi nhân gian sum vầy\n" + "Em có nghe thấy\n" + "Tiếng réo gọi tâm hồn\n" + "Ngân vang đâu đây\n" + "\n" + "[Verse 3: Đen]\n" + "Đi với anh đến cùng trời cuối đất\n" + "Và để nếm yêu thương\n" + "Không dùng lời muối mật\n" + "Mình sống chẳng tự cao\n" + "Hay việc gì phải cúi mặt\n" + "Đi đi em còn do dự trời tối mất\n" + "\n" + "Và anh đưa em đi đến nơi ít người qua\n" + "Nơi vầng trăng mỏng cong veo tít trời xa\n" + "Nơi những vì sao\n" + "Chẳng phải nép sau nóc nhà và\n" + "Nơi đặt lưng xuống đầu\n" + "Chẳng nặng chuyện ngày qua\n" + "\n" + "Có đường cong như mi em\n" + "Có đường thẳng như sống mũi\n" + "Có đường ngắn có đường dài\n" + "Đi về đâu ai đoán nổi\n" + "Anh sẽ đưa em qua hết\n" + "Cho tóc bạc đi vì bụi\n" + "Có gian khó, có mệt nhoài\n" + "Ta mới tạc ghi vào cội\n" + "\n" + "Đi với anh\n" + "Và tạm quên chuyện tương lai\n" + "Giờ đây quan trọng với anh là:\n" + "Tóc em còn đương dài\n" + "Môi em còn nồng thắm\n" + "Và mắt em như sương mai\n" + "Đi thật xa để khi trở\n" + "Còn biết chắc mình thương ai!\n" + "\n" + "[Bridge: Ngọt]\n" + "Cho tôi đi theo với\n" + "Nơi em đi về\n" + "Về nơi đẹp trời hơn\n" + "Tràn đầy đam mê\n" + "\n" + "Tôi quên đi năm tháng\n" + "Yêu thương không còn\n" + "Cần thêm mùi rượu vang\n" + "Và đồ ăn ngon\n" + "\n" + "[Verse 4: Đen]\n" + "Vì ngày lang thang vẫn còn dài\n" + "Nên ta không kéo ga thật sâu\n" + "Vì đôi chân và mặt đường\n" + "Vốn dĩ nó đã không xa được nhau\n" + "Vì lá thì rơi, sương thì đọng\n" + "Đá bất động, người thì đi\n" + "\n" + "Nên tóc còn xanh, máu còn nóng\n" + "Nằm một chỗ để làm chi\n" + "Vì lá thì rơi, sương thì đọng\n" + "Đá bất động, người thì đi\n" + "Nên tóc còn xanh, máu còn nóng\n" + "Nằm một chỗ để làm chi"))
        arraysong.add(OutData( "Đập Vỡ Cây Đàn", "Quang Lê", R.raw.dapvocaydan,"Đập vỡ cây đàn\n" + "Giận đời đập vỡ cây đàn\n" + "Người ơi người ơi\n" + "Tình ơi tình ơi\n" + "Đập vỡ cây đàn giận đời\n" + "Bạc trắng như vôi\n" + "Giận người điên đảo\n" + "Quên lời\n" + "Đập vỡ cây đàn giận người\n" + "Con gái yêu đàn\n" + "Buồn ơi buồn ơi\n" +
                "Làm sao để nguôi\n" + "Đập vỡ cây đàn giận người\n" + "Đổi trắng thay đen\n" + "Giận đời trở như bàn tay\n" + "Chuyện ngày qua\n" + "Tôi gặp người con gái\n" + "Mang giọng ca thật buồn\n" + "Em bảo tôi rằng\n" + "Anh đi học đàn\n" + "Để đàn theo lúc em ca\n" + "Những ngày hoa mộng đời ta\n" +
                "Tôi yêu nàng\n" +
                "Nên vội vàng lên tỉnh\n" + "Đi tìm theo học đàn\n" +
                "Sau một năm trường\n" +
                "Tôi trở về quê hương\n" + "Nhưng người con gái\n" +
                "Ngày ấy đã đi rồi\n" +
                "Tôi hỏi thăm dò từng người\n" +
                "Trong xóm tin nàng\n" +
                "Nàng đâu nàng đâu\n" +
                "Nàng đâu nàng đâu\n" +
                "Người báo tin buồn\n" +
                "Nàng gặp nhạc sĩ vang danh\n" +
                "Rồi cùng xây đắp gia đình\n" +
                "Tôi xót thương nàng\n" +
                "Và rồi tôi khóc thương mình\n" +
                "Đời ơi còn chi\n" +
                "Đàn ơi biệt ly\n" +
                "Đập vỡ cây đàn giận người\n" +
                "Đổi trắng thay đen\n" +
                "Giận đời trở như bàn tay\n" +
                "\n" +
                "Chuyện ngày qua\n" +
                "Tôi gặp người con gái\n" +
                "Mang giọng ca thật buồn\n" +
                "Em bảo tôi rằng\n" +
                "Anh đi học đàn\n" +
                "Để đàn theo lúc em ca\n" +
                "Những ngày hoa mộng đời ta\n" +
                "Tôi yêu nàng\n" +
                "Nên vội vàng lên tỉnh\n" +
                "Đi tìm theo học đàn\n" +
                "Sau một năm trường\n" +
                "Tôi trở về quê hương\n" +
                "Nhưng người em gái\n" +
                "Ngày ấy đã đi rồi\n" +
                "Tôi hỏi thăm dò từng người\n" +
                "Trong xóm tin nàng\n" +
                "Nàng đâu nàng đâu\n" +
                "Nàng đâu nàng đâu\n" +
                "Người báo tin buồn\n" +
                "Nàng gặp nhạc sĩ vang danh\n" +
                "Rồi cùng xây đắp gia đình\n" +
                "Tôi xót thương nàng\n" +
                "Và rồi tôi khóc thương mình\n" +
                "Đời ơi còn chi\n" +
                "Đàn ơi biệt ly\n" +
                "Đập vỡ cây đàn giận người\n" +
                "Đổi trắng thay đen\n" +
                "Giận đời trở như bàn tay\n" +
                "Đập vỡ cây đàn giận người\n" +
                "Đổi trắng thay đen\n" +
                "Giận đời trở như bàn tay"))
        arraysong.add(OutData( "Em Là Hạnh Phúc Trong Anh", "Hồ Quanng Hiếu", R.raw.emlahanhphuctronganh ,"Mai ta xa rồi chẳng thể nói nhau đôi lời\n" +
                "Ngày qua anh đã quá yêu em\n" +
                "Một đêm cô đơn lại trôi\n" +
                "Anh thẫn thờ và suy nghĩ\n" +
                "Về em, về những yêu thương.\n" +
                "\n" +
                "Anh yêu em nhiều chỉ mong em sẽ hiểu\n" +
                "Em là hạnh phúc đời anh\n" +
                "Chẳng còn bên nhau thật lâu\n" +
                "Để rồi ngày mai xa nhau\n" +
                "Ngày em đi khoảng lặng trong tim anh.\n" +
                "\n" +
                "[ĐK:]\n" +
                "Yêu em mãi mãi, yêu em suốt kiếp\n" +
                "Ngày tháng cứ trôi sao chỉ mình anh thôi\n" +
                "Hạnh phúc ấm áp, căn phòng xưa vẫn còn\n" +
                "Nhưng nụ cười em đã mãi xa rồi.\n" +
                "\n" +
                "Yêu em mãi mãi, yêu em suốt kiếp\n" +
                "Hãy để cho anh thêm một lần yêu em\n" +
                "Được mãi ấm áp, hiu quạnh khi đêm về\n" +
                "Nhưng anh biết giờ đã mất em rồi, người ơi.\n" +
                "(Nhưng anh biết giờ đã mãi mất em, người yêu ơi.)"))
        arraysong.add(OutData( "Mặt Trái Của Sự Thật", "HKT", R.raw.mattraicuasuthat,"Người ta nói em yêu tôi, người ta nói em thương tôi, bên tôi vui buồn xớt chia.\n Người ta thấy em pên tôi, và người ta ước mong như tôi, xem tôi là người hạnh phúc.\n" +
                "\n" +
                "Mà người ta đâu có hay, lòng tôi như vỡ tan, vẫn vui tươi pên người yêu.\n Mặc cho em lun thản nhiên, và mặc cho em đang đóng phim, 1 cuốn phim cho bao người xem.\n" +
                "\n" +
                "Đk:\n" +
                "Chỉ là hình thức em quan tâm tôi như người yêu, trước mắt thế gian đâu ai hay biết 1 sự thật.\n Rằng em không yêu tôi, rằng em không thương tôi, em chỉ xem tôi như 1 tấm bia chắn.\n" +
                "\n" +
                "Tội nghiệp cho tôi bơ vơ cô đơn trong màn đêm. Khi biết em say mê trong tim 1 bóng hình,\n người mà em lun yêu thương, người cho em bao giấc mơ, những giấc mơ của 2 người đàn bà."))
        arraysong.add(OutData( "Một Nhà", "DaLAB", R.raw.motnha,"JGKiD:\n" +
                "Khi hai ta về một nhà \n" +
                "Khép đôi mi chung một giường \n" +
                "Đôi khi mơ cùng một giấc \n" +
                "Thức giấc chung một giờ \n" +
                "Khi hai ta chung một đường \n" +
                "Ta vui chung một nỗi vui \n" +
                "Nước mắt rơi một dòng \n" +
                "Sống chung nhau một đời\n" +
                "\n" +
                "Rabbit Run:\n" +
                "Vẫn ánh mắt ấy sáng long lanh\n" +
                "Như trời cao mây trắng trong lành\n" +
                "Đến hôm nay anh vẫn chưa thể tin em đã về đây với anh\n" +
                "\n" +
                "Nhớ những lúc đứng dưới mái trường xưa\n" +
                "Cùng dừng xe dưới gốc cây trú mưa\n" +
                "Đến hôm nay ta đã chung 1 lối anh không còn phải đi xa đón đưa\n" +
                "\n" +
                "Ta giờ đây chung trời mây ta cùng đón tương lai\n" +
                "Tay cầm tay ta cùng vui say chân bước đường dài\n" +
                "Như lời hứa anh đã nói ngay từ phút giây đầu chúng ta sẽ về chung 1 nhà\n" +
                "\n" +
                "Dẫu gian khó dẫu mưa gió ta cùng đón ngày mai\n" +
                "Ta thường nghe sau cơn mưa là trời sẽ nắng lại\n" +
                "Như lời hứa anh đã nói ngay từ phút giây đầu chúng ta đã về chung 1 nhà\n" +
                "\n" +
                "JGKiD:\n" +
                "Khi hai ta về một nhà \n" +
                "Khép đôi mi chung một giường \n" +
                "Đôi khi mơ cùng một giấc \n" +
                "Thức giấc chung một giờ \n" +
                "Khi hai ta chung một đường \n" +
                "Ta vui chung một nỗi vui \n" +
                "Nước mắt rơi một dòng \n" +
                "Sống chung nhau một đời\n" +
                "\n" +
                "MPaKK:\n" +
                "A lô em à anh đang lấy xe, chuẩn bị ra về\n" +
                "10 tiếng mệt mỏi sau lưng muốn kể với em, ngày dài ghê\n" +
                "Công trường nắng gió bụi bặm làm anh, mỏi nhừ cả đôi vai\n" +
                "Những chuyện nhỏ to công việc vẫn còn, văng vẳng bên tai\n" +
                "\n" +
                "“Này anh hôm nay anh có thể về, về nhà, sớm hơn\n" +
                "Buổi tối hôm nay có món anh thích, cả nhà, chờ cơm”\n" +
                "Em ơi hôm nay anh về muộn, đang vội, đến, phòng thu\n" +
                "Bản tin thời sự và mixtape, vẫn còn đang ấp ủ\n" +
                "\n" +
                "anh biết từ khi lấy em anh chẳng mấy khi phụ em được việc nhà\n" +
                "cuối tuần bận bịu hát hò chẳng cùng em được, chuyện, gần xa\n" +
                "đêm ngày lo viết câu hát về người ta, thừa hơi bao đồng\n" +
                "đi diễn chỗ này chỗ kia tối về với em cũng chỉ có tay không\n" +
                "\n" +
                "Cảm ơn em vì những tháng ngày, qua em đã đến bên anh\n" +
                "Cảm ơn em đã là, hậu phương, cho ước mơ trong anh\n" +
                "Xin lỗi em vì những tối em thức, muộn, nhịn đói, chờ cơm\n" +
                "Anh rất yêu em và con bài này anh viết xin tặng, 2 mẹ con\n" +
                "\n" +
                "JGKiD:\n" +
                "Khi hai ta về một nhà \n" +
                "Khép đôi mi chung một giường \n" +
                "Đôi khi mơ cùng một giấc \n" +
                "Thức giấc chung một giờ \n" +
                "Khi hai ta chung một đường \n" +
                "Ta vui chung một nỗi vui \n" +
                "Nước mắt rơi một dòng \n" +
                "Sống chung nhau một đời"))
        arraysong.add(OutData("My Every Thing", "Tiên Tiên", R.raw.myeverything,"Em đang hát về người yêu dấu ơi, có nghe chăng\n" +
                "Em đem tiếng cười bờ môi ấy, xa chốn đây\n" +
                "Những giây phút ghì chặt tay nhau\n" +
                "Những câu nói thì thầm bên tai bấy lâu\n" +
                "Mùi hương thân quen còn in trên vạt áo\n" +
                "Em sẽ nói anh nghe anh nghe về đại dương xanh\n" +
                "Em sẽ hát anh nghe anh nghe bản tình ca em với anh\n" +
                "Ta sẽ nắm tay nhau đi chung trên từng con phố quen\n" +
                "Ih-yeah ih-yeah ha\n" +
                "La-la-la, la-la-la-la, la-la-la-la\n" +
                "You are my everything\n" +
                "La-la-la, la-la-la-la, la-la-la-la\n" +
                "You're enough 'n the best to me\n" +
                "La-la-la, la-la-la-la, la-la-la-la\n" +
                "You are my everything\n" +
                "La-la-la, la-la-la-la, la-la-la-la\n" +
                "You're enough 'n the best to me\n" +
                "Em luôn ước mình được ôm lấy anh, mỗi sớm mai\n" +
                "Trao anh những lời ngọt ngào thiết tha oh my boy\n" +
                "Những tia nắng vàng sau cơn mưa\n" +
                "Những con phố hằng ngày đi xa đón đưa\n" +
                "Mùi hương thân quen còn in trên vạt áo\n" +
                "La-la-la, la-la-la, la-la-la, la-la-la\n" +
                "Em sẽ nói anh nghe anh nghe về đại dương xanh\n" +
                "Em sẽ hát anh nghe anh nghe bản tình ca em với anh\n" +
                "Ta sẽ nắm tay nhau đi chung trên từng con phố quen\n" +
                "Ih-yeah ih-yeah ha\n" +
                "La-la-la, la-la-la-la, la-la-la-la\n" +
                "You are my everything\n" +
                "La-la-la, la-la-la-la, la-la-la-la\n" +
                "You're enough 'n the best to me\n" +
                "Sometimes you make me cry\n" +
                "But I dont wanna say goodbye\n" +
                "Uh-hu-hu-uu\n" +
                "Em sẽ nói anh nghe anh nghe về đại dương xanh\n" +
                "Em sẽ hát anh nghe anh nghe bản tình ca em với anh\n" +
                "Ta sẽ nắm tay nhau đi chung trên từng con phố quen\n" +
                "Ih-yeah ih-yeah ha"))
        arraysong.add(OutData( "Nắm Lấy Tay Anh", "Tuấn Hưng", R.raw.namlaytayanh,"Ngày ta sánh đôi, hạnh phúc nói cười\n" +
                "Chỉ mong thế thôi, đến tận cuối cùng\n" +
                "Từng giây phút trôi, ánh mắt rạng ngời\n" +
                "Cầm tay bước đi, tiếng yêu cất lời\n" +
                "Và anh cám ơn cuộc đời này\n" +
                "Đã mang em về bên mình để rồi\n" +
                "Mỗi sớm mai khi thức dậy, anh nói rằng\n" +
                "Hãy yêu anh và bên anh người nhé!\n" +
                "Nắm tay anh thật chặt, giữ tay anh thật lâu\n" +
                "Hứa với anh một câu sẽ đi chọn tới cuối con đường\n" +
                "Đến khi tim ngừng đập và đôi chân ngừng đi\n" +
                "Vì em yêu ơi xin em hãy cứ tin\n" +
                "Nắm tay nhau thật chặt, giữ tay nhau thật lâu\n" +
                "Để hứa với nhau một câu sẽ đi chọn tới cuối con đường\n" +
                "Đến khi tim ngừng đập và đôi chân ngừng đi\n" +
                "Thì đôi ta cũng sẽ không xa rời\n" +
                "Ngày ta sánh đôi, hạnh phúc nói cười\n" +
                "Chỉ mong thế thôi, đến tận cuối cùng\n" +
                "Từng giây phút trôi, ánh mắt rạng ngời\n" +
                "Cầm tay bước đi, tiếng yêu cất lời\n" +
                "Và anh cám ơn cuộc đời này\n" +
                "Đã mang em về bên mình để rồi\n" +
                "Mỗi sớm mai khi thức dậy, anh nói rằng\n" +
                "Hãy yêu anh và bên anh người nhé!\n" +
                "Nắm tay anh thật chặt, giữ tay anh thật lâu\n" +
                "Hứa với anh một câu sẽ đi chọn tới cuối con đường\n" +
                "Đến khi tim ngừng đập và đôi chân ngừng đi\n" +
                "Vì em yêu ơi xin em hãy cứ tin\n" +
                "Nắm tay nhau thật chặt, giữ tay nhau thật lâu\n" +
                "Để hứa với nhau một câu sẽ đi chọn tới cuối con đường\n" +
                "Đến khi tim ngừng đập và đôi chân ngừng đi\n" +
                "Thì đôi ta cũng sẽ không xa rời\n" +
                "Nắm tay nhau thật chặt, giữ tay nhau thật lâu\n" +
                "Hứa với nhau một câu sẽ đi chọn tới cuối con đường\n" +
                "Đến khi tim ngừng đập và đôi chân ngừng đi\n" +
                "Thì em yêu ơi xin em hãy cứ tin\n" +
                "Nắm tay nhau thật chặt, giữ tay nhau thật lâu\n" +
                "Hứa với nhau một câu sẽ đi trọn đến cuối con đường\n" +
                "Đến khi tim ngừng đập và đôi chân ngừng đi\n" +
                "Thì đôi ta cũng sẽ không xa rời"))
        arraysong.add(OutData( "Nơi Này Có Anh", "Masew-Bootleg-Sơn Tùng M-TP", R.raw.noinaycoanh,"Anh là ai từ đâu bước đến nơi đây dịu dàng chân phương\n" +
                "Anh là ai tựa như ánh nắng ban mai ngọt ngào trong sương\n" +
                "Ngắm anh thật lâu\n" +
                "Con tim em yếu mềm\n" +
                "Đắm say từ phút đó\n" +
                "Từng giây trôi yêu thêm\n" +
                "\n" +
                "Bao ngày qua bình minh đánh thức \n" +
                "Xua tan bộn bề nơi em\n" +
                "Bao ngày qua niềm thương nỗi nhớ\n" +
                "Bay theo bầu trời trong xanh\n" +
                "Liếc đôi hàng mi\n" +
                "Con tim em thẫn thờ\n" +
                "Muốn hôn nhẹ mái tóc\n" +
                "Bờ môi anh, em mơ\n" +
                "\n" +
                "Cầm tay em dựa vai em\n" +
                "Kề bên em nơi này có em\n" +
                "Gió mang câu tình ca\n" +
                "Ngàn ánh sao vụt qua nhẹ ôm lấy anh\n" +
                "Cầm tay em dựa vai em\n" +
                "Kề bên em nơi này có em\n" +
                "Khép đôi mi thật lâu\n" +
                "Nguyện mãi bên cạnh nhau\n" +
                "Yêu say đắm như ngày đầu\n" +
                "\n" +
                "Mùa xuân đến bình yên\n" +
                "Cho em những giấc mơ\n" +
                "Hạ lưu giữ ngày mưa\n" +
                "Ngọt ngào nên thơ\n" +
                "Mùa thu lá vàng rơi\n" +
                "Đông sang anh nhớ em\n" +
                "Tình yêu bé nhỏ\n" +
                "Xin dành tặng riêng anh"))
        arraysong.add(OutData("Sau Tất Cả", "Erik", R.raw.sautatca,"Sau tất cả mình lại trở về với nhau\n" +
                "Tựa như chưa bắt đầu, tựa như ta vừa mới quen\n" +
                "Sau tất cả lòng chẳng hề đổi thay\n" +
                "Từng ngày xa lìa khiến con tim bồi hồi\n" +
                "Và ta lại gần nhau hơn nữa\n" +
                "\n" +
                "[Pre-chorus]\n" +
                "Có những lúc đôi ta giận hờn\n" +
                "Thầm trách nhau không một ai nói điều gì\n" +
                "Thời gian cứ chậm lại, từng giây phút sao quá dài\n" +
                "Để khiến anh nhận ra mình cần em hơn\n" +
                "\n" +
                "[Chorus]\n" +
                "Tình yêu cứ thế đong đầy trong anh từng ngày\n" +
                "Vì quá yêu em nên không thể làm gì khác\n" +
                "Chỉ cần ta mãi luôn dành cho nhau những chân thành\n" +
                "Mọi khó khăn cũng chỉ là thử thách\n" +
                "Vì trái tim ta luôn luôn thuộc về nhau\n" +
                "\n" +
                "Sau tất cả mình lại chung lối đi\n" +
                "Đoạn đường ta có nhau, bàn tay nắm chặt bấy lâu\n" +
                "Sau tất cả mình cùng nhau sẻ chia\n" +
                "Muộn phiền không thể khiến đôi tim nhạt nhoà\n" +
                "Và ta lại gần nhau hơn nữa\n" +
                "\n" +
                "[Pre-chorus]\n" +
                "\n" +
                "[Chorus]\n" +
                "\n" +
                "Giữ chặt bàn tay mình cùng nhau đi hết bao tháng ngày\n" +
                "Mọi điều gian khó ta luôn vượt qua\n" +
                "Để khiến ta nhận ra mình gần nhau hơn"))
        arraysong.add(OutData("Sầu Tím Thiệp Hồng", "Quang Lê - Lệ Quyên", R.raw.sautimthiephong,"Từ lúc quen nhau chưa nói một lời gì, tỏ tình ta mến nhau\n" +
                "Nhiều đêm ngắm sao mà ước duyên mình bền lâu, suốt đời tình khắc sâu\n" +
                "Nhớ thương đầy vơi, mộng thấy ai mỉm cười, làn môi xinh tuyệt vời\n" +
                "Để rồi buồn ơi, anh trăng soi còn đó, và nghe hơi gió biết rằng mình vừa mơ\n" +
                "Khi yêu, hồn như nở hoa xây mộng tuyệt vời\n" +
                "Nắm tương lai trong bàn tay một câu nói thôi\n" +
                "Đôi khi gặp nhau, muốn khơi nhưng rồi lại thôi\n" +
                "Nói ra e ngại mặc theo gió trôi\n" +
                "Hôm nay nhìn xe kết hoa xuôi ngược nẻo đường\n" +
                "Gửi thư trao cho người yêu, vài câu luyến thương\n" +
                "Hân hoan hồn như nở hoa trông chờ hồi âm\n" +
                "Đắng cay trong lòng chỉ thấy thiệp hồng\n" +
                "Chiều tím không mây, đường cũ bước lần về, buồn nghe day dứt tim\n" +
                "Nhìn xe kết hoa màu trắng ngỡ rằng mình mơ, pháo hồng nhuộm tiễn đưa\n" +
                "Lá thu chậm rơi từng lá nghe buồn buồn, tưởng bước ai tìm về\n" +
                "Mở rộng vòng tay đón anh nhưng nào thấy?\n" +
                "Sầu dâng lên tim, biết bao giờ cho khuây?\n" +
                "Hôm nay nhìn xe kết hoa xuôi ngược nẻo đường\n" +
                "Gửi thư trao cho người yêu, vài câu luyến thương\n" +
                "Hân hoan hồn như nở hoa trông chờ hồi âm\n" +
                "Đắng cay trong lòng chỉ thấy thiệp hồng\n" +
                "Chiều tím không mây, đường cũ bước lần về, buồn nghe day dứt tim\n" +
                "Nhìn xe kết hoa màu trắng ngỡ rằng mình mơ, pháo hồng nhuộm tiễn đưa\n" +
                "Lá thu chậm rơi từng lá nghe buồn buồn tưởng bước ai tìm về\n" +
                "Mở rộng vòng tay đón anh nhưng nào thấy?\n" +
                "Sầu dâng lên tim, biết bao giờ cho khuây?\n" +
                "Mở rộng vòng tay đón anh nhưng nào thấy\n" +
                "Sầu dâng lên tim, biết bao giờ cho khuây?"))
        arraysong.add(OutData( "Thu Cuối", "Mr-T-Yanbi-Hang-BingBoong", R.raw.thucuoi,"Cho bao nhiêu yêu thương nay bay xa\n" +
                "Hoen đôi mi khi thu đưa em qua\n" +
                "Đã từng ngọt ngào, giờ nhận đắng cay vì anh\n" +
                "Thu vờn tóc em mơn man bên làn gió\n" +
                "Vương trên mi ai lá rụng con phố nhỏ\n" +
                "Nhẹ nhàng đâu đây mùi hương hoa sữa đó\n" +
                "Nghe xung quanh âm thanh vang lên sao thân quen\n" +
                "Trong bao nhiêu ngu ngơ vu vơ mùa lá vắng\n" +
                "Thật nhẹ nhàng dù mùa thu không còn yêu anh nữa\n" +
                "\n" +
                "Đã từ rất lâu rồi\n" +
                "Trong anh định nghĩa hai tiếng yêu thương\n" +
                "Anh không thể trao cho ai kể từ khi anh có em\n" +
                "Mùa thu đó anh có em\n" +
                "Vậy cớ sao giờ\n" +
                "Hơn một năm trôi qua người đã khác xa thật nhiều\n" +
                "Anh nghe tiếng lá rơi không còn em nữa\n" +
                "Và mùa thu đến anh không còn em nữa\n" +
                "\n" +
                "Có lẽ nào em vội quên đi\n" +
                "Và có lẽ nào em đưa mùa thu đi\n" +
                "Có lẽ nào mùa thu chẳng còn lại gì\n" +
                "Trong tâm trí em\n" +
                "\n" +
                "Có lẽ nào em buông anh đi xa mất\n" +
                "Có lẽ nào anh không phải người mà em yêu nhất\n" +
                "Có lẽ nào\n" +
                "Anh phải tự nhủ rằng chỉ là một giấc mơ\n" +
                "Anh mất em rồi\n" +
                "\n" +
                "Thu đến và đi như những gì đã sắp đặt\n" +
                "Trang giấy trắng đâu thể mờ đi từng màu buồn của nắng\n" +
                "À ơi vu vơ câu hát có lẽ chưa bao giờ anh viết tặng\n" +
                "Em nhẹ bước chân qua bao ngọt ngào, bao nhiêu cố gắng\n" +
                "Có hay không những bước thềm trong con tim em cần một khoảng rộng?\n" +
                "Biết lúc nào anh có thể lại được gặp em một lần nữa\n" +
                "Là khi đó anh cảm nhận mùi hương tàn cánh hoa sữa\n" +
                "Anh yêu em thật nồng nàn như một định lí đã muôn thuở\n" +
                "\n" +
                "Yêu!\n" +
                "Một người có lẽ phải học thêm nhiều điều\n" +
                "Em là mảnh ghép cuối cùng anh còn thiếu\n" +
                "Nhiều đêm dằn vặt tự gắng mình không hiểu\n" +
                "Lắm những yêu thương trôi qua trong em nào thật nhiều\n" +
                "Không!\n" +
                "Lí do nào đã khiến em cùng người đó gặp mặt rồi vội yêu?\n" +
                "Cánh cửa hy vọng như đang đổ sập ngay trước mắt\n" +
                "Không còn hơi ấm nụ hôn bờ vai êm thật chặt\n" +
                "Cảm xúc bỗng như chết lặng\n" +
                "Đông tới ghé nhắn anh rằng\n" +
                "Thu cuối rồi cũng qua nhanh cuốn theo cơn gió lặng lẽ hòa tan vào trong\n" +
                "Một buổi chiều mưa vắng, yeah\n" +
                "\n" +
                "Lê đôi chân bơ vơ anh đã hụt hẫng thật nhiều (thật nhiều)\n" +
                "Sao anh không thể ngăn được nước mắt nhạt nhoà? (vì ai)\n" +
                "Đành ôm bờ vai lạnh cuối thu\n" +
                "Cho anh thêm ngậm ngùi (vì anh)\n" +
                "Cho bao nhiêu yêu thương vụt bay\n" +
                "Cho bao nhiêu yêu thương mãi xa (mãi xa)\n" +
                "Và xa cuối tận chân trời\n" +
                "\n" +
                "Có lẽ nào em vội quên đi\n" +
                "Và có lẽ nào em đưa mùa thu đi\n" +
                "Có lẽ nào mùa thu chẳng còn lại gì\n" +
                "Trong tâm trí em\n" +
                "\n" +
                "Có lẽ nào em buông anh đi xa mất\n" +
                "Có lẽ nào anh không phải người mà em yêu nhất\n" +
                "Có lẽ nào\n" +
                "Anh phải tự nhủ rằng chỉ là một giấc mơ\n" +
                "Và anh đã mất em rồi\n" +
                "\n" +
                "Hà Nội có lẽ đẹp nhất về đêm\n" +
                "Cũng chính là lúc ôm em thật chặt băng qua mọi nẻo phố cổ ta thường đến\n" +
                "Nhắm mắt chạm nhẹ nỗi đau miền không tên\n" +
                "Giật mình chợt nhớ anh không thể với đến\n" +
                "Chỉ là giấc mơ quá êm đềm\n" +
                "Trọn vẹn một vòng tay dịu êm\n" +
                "Rồi cứ man mác vu vơ ngẩn ngơ chờ đông tới\n" +
                "Liệu rằng một mai sẽ còn thấy nhau trên đường đời?\n" +
                "Ta cũng đâu ngờ sau bao ngày chờ đợi\n" +
                "Bài hát cất lên về thu Hà Nội sẽ theo cùng em\n" +
                "Nhưng cùng hình bóng mới\n" +
                "Và có lẽ nào\n" +
                "\n" +
                "Có lẽ nào em vội quên đi (có lẽ, có lẽ nào)\n" +
                "Và có lẽ nào em đưa mùa thu đi (có lẽ, có lẽ nào)\n" +
                "Có lẽ nào mùa thu chẳng còn lại gì\n" +
                "Trong tâm trí em\n" +
                "\n" +
                "Có lẽ nào em buông anh đi xa mất (có lẽ, có lẽ nào)\n" +
                "Có lẽ nào anh không phải người mà em yêu nhất (có lẽ, có lẽ nào)\n" +
                "Có lẽ nào\n" +
                "Anh phải tự nhủ rằng chỉ là một giấc mơ\n" +
                "Anh mất em rồi\n" +
                "\n" +
                "Có lẽ nào em vội quên đi (có lẽ, có lẽ nào)\n" +
                "Và có lẽ nào em đưa mùa thu đi (có lẽ, có lẽ nào)\n" +
                "Có lẽ nào mùa thu chẳng còn lại gì\n" +
                "Trong tâm trí em\n" +
                "\n" +
                "Có lẽ nào em buông anh đi xa mất (có lẽ, có lẽ nào)\n" +
                "Có lẽ nào anh không phải người mà em yêu nhất (có lẽ, có lẽ nào)\n" +
                "Có lẽ nào\n" +
                "Anh phải tự nhủ rằng chỉ là một giấc mơ (chỉ là một giấc mơ)\n" +
                "Anh mất em rồi"))
        arraysong.add(OutData( "Túy Âm", "Xesi-Masew-Nhat Nguyen", R.raw.tuyam,"Rót đến tràn ly\n" +
                "Anh chìm đắm trong\n" +
                "Men cay đắng nồng\n" +
                "Khóc chát làn mi\n" +
                "Uống cùng anh cho\n" +
                "Đêm này say chất ngất\n" +
                "Dẫu năm tháng ấy\n" +
                "Còn đâu những đam mê\n" +
                "Ta kiếm tìm\n" +
                "Màu mắt xanh ngời\n" +
                "Lạc giữa mây ngàn\n" +
                "Về chốn xa xôi\n" +
                "Hãy say cùng anh\n" +
                "Hãy hát cùng anh\n" +
                "Hãy khóc cùng anh\n" +
                "Thêm một lần\n" +
                "Để anh được gần\n" +
                "Trái tim của em\n" +
                "Dù trong phút giây\n" +
                "Hình bóng người tan biến dần\n" +
                "Phía sau những nỗi sầu\n" +
                "Với em chắc quá đủ\n" +
                "Cho một mối tình\n" +
                "Dẫu em không thể\n" +
                "Ở lại với anh\n" +
                "Mình chẳng cùng với nhau\n" +
                "Đi hết quãng đường\n" +
                "Ôm ấp hy vọng\n" +
                "Một ngày ngát xanh\n" +
                "Tháng năm thăng trầm\n" +
                "Dòng đời ngả nghiêng\n" +
                "Mình tự rời bỏ nhau\n" +
                "Say đến điên dại\n" +
                "Say hết kiếp người\n" +
                "Say cho cháy đời\n" +
                "Hãy say cùng anh\n" +
                "Hãy hát cùng anh\n" +
                "Dẫu em không thể\n" +
                "Ở lại với anh\n" +
                "Mình chẳng cùng với nhau\n" +
                "Đi hết quãng đường\n" +
                "Ôm ấp hy vọng\n" +
                "Một ngày ngát xanh\n" +
                "Tháng năm thăng trầm\n" +
                "Dòng đời ngả nghiêng\n" +
                "Mình tự rời bỏ nhau\n" +
                "Say đến điên dại\n" +
                "Say hết kiếp người\n" +
                "Say cho cháy đời\n" +
                "Hãy say cùng anh\n" +
                "Hãy hát cùng anh\n" +
                "Dẫu em không thể\n" +
                "Ở lại với anh\n" +
                "Mình chẳng cùng với nhau\n" +
                "Đi hết quãng đường\n" +
                "Ôm ấp hy vọng\n" +
                "Một ngày ngát xanh\n" +
                "Tháng năm thăng trầm\n" +
                "Dòng đời ngả nghiêng\n" +
                "Mình tự rời bỏ nhau\n" +
                "Say đến điên dại\n" +
                "Say hết kiếp người\n" +
                "Say cho cháy đời"))
        arraysong.add(OutData( "Vợ Người Ta", "Phan Mạnh Quỳnh", R.raw.vonguoita,"Tấm thiệp mời trên bàn\n" +
                "Thời gian địa điểm rõ ràng\n" +
                "Lại một đám mừng ở trong làng\n" +
                "Ngó tên bỗng dưng thấy hoang mang\n" +
                "Rồi ngày cưới rộn ràng khắp vùng\n" +
                "Ai theo chân ai tới già trẻ đi cùng\n" +
                "Nhiều ngày tháng giờ này tương phùng mà lòng cay, cay, cay\n" +
                "\n" +
                "[Chorus]\n" +
                "Giờ em đã là vợ người ta\n" +
                "Áo trắng cô dâu cầm hoa\n" +
                "Nhạc tung tóe thanh niên hòa ca\n" +
                "Vài ba đứa lên lắc lư theo\n" +
                "Ấy là thành đám cưới em với người ta\n" +
                "Anh biết do anh mà ra\n" +
                "Tình yêu ấy nay xa càng xa\n" +
                "Buồn thay la-la-lá\n" +
                "Buồn thay la-lá-là-la\n" +
                "Oh-oh\n" +
                "\n" +
                "[Verse 2]\n" +
                "Nghĩ nhiều chuyện trong đời\n" +
                "Anh thấy lòng càng rối bời\n" +
                "Liệu ngày đó nhiệt tình ngỏ lời\n" +
                "Chúng ta lấy nhau chứ em ơi?\n" +
                "Đành bảo phó mặc ở duyên trời\n" +
                "Nhưng thâm tâm anh trách nàng tại sao vội\n" +
                "Một người bước, một người không đợi\n" +
                "Thì đành tìm ai, ai, ai?"))
        arraysong.add(OutData( "Yêu Lại Từ Đầu", "Khắc Việt", R.raw.yeulaitudau,"Em ơi! Hình như chúng mình\n" +
                "Đã hết yêu nhau mất rồi\n" +
                "Tại vì sao em hãy nói đi\n" +
                "Hay vì anh vô tâm hững hờ\n" +
                "Nên vô tình đánh mất hai ta\n" +
                "\n" +
                "Rất khó để đến với nhau\n" +
                "Đừng buông xuôi tình yêu chúng mình\n" +
                "Mình đã hứa với nhau những gì\n" +
                "Mình hãy giữ trọn vẹn lời hứa\n" +
                "Hãy cho ta yêu nhau thêm một lần nữa\n" +
                "\n" +
                "Mình tạm chia tay nhau nhé em\n" +
                "Để ta biết đc có yêu nhau không?\n" +
                "Mình tự cho nhau hai lối đi\n" +
                "Để xem quãng đường của ai xa hơn\n" +
                "Thời gian sẽ nói lên tất cả\n" +
                "Nếu ta còn yêu sẽ quay trở về\n" +
                "Thì lúc đó hai ta sẽ cùng mở rộng trái tim\n" +
                "Và cùng cho nhau\n" +
                "Yêu lại từ đầu\n" +
                "\n" +
                "Em ơi! Hình như chúng mình\n" +
                "Đã hết yêu nhau mất rồi\n" +
                "Tại vì sao em hãy nói đi\n" +
                "Hay vì anh vô tâm hững hờ\n" +
                "Nên vô tình đánh mất hai ta\n" +
                "\n" +
                "Rất khó để đến với nhau\n" +
                "Đừng buông xuôi tình yêu chúng mình\n" +
                "Mình đã hứa với nhau những gì\n" +
                "Mình hãy giữ trọn vẹn lời hứa\n" +
                "Hãy cho ta yêu nhau thêm một lần nữa\n" +
                "\n" +
                "Mình tạm chia tay nhau nhé em\n" +
                "Để ta biết đc có yêu nhau không?\n" +
                "Mình tự cho nhau hai lối đi\n" +
                "Để xem quãng đường của ai xa hơn\n" +
                "Thời gian sẽ nói lên tất cả\n" +
                "Nếu ta còn yêu sẽ quay trở về\n" +
                "Thì lúc đó hai ta sẽ cùng mở rộng trái tim\n" +
                "Và cùng cho nhau...\n" +
                "Yêu lại từ đầu\n" +
                "\n" +
                "Mình tạm chia tay nhau nhé em\n" +
                "Để ta biết đc có yêu nhau không?\n" +
                "Mình tự cho nhau hai lối đi\n" +
                "Để xem quãng đường của ai xa hơn\n" +
                "Thời gian sẽ nói lên tất cả\n" +
                "Nếu ta còn yêu sẽ quay trở về\n" +
                "Thì lúc đó hai ta sẽ cùng mở rộng trái tim\n" +
                "Và cùng cho nhau\n" +
                "\n" +
                "Mình tạm chia tay nhau nhé em\n" +
                "Để ta biết đc có yêu nhau không?\n" +
                "Mình tự cho nhau hai lối đi\n" +
                "Để xem quãng đường của ai xa hơn\n" +
                "Thời gian sẽ nói lên tất cả\n" +
                "Nếu ta còn yêu sẽ quay trở về\n" +
                "Thì lúc đó hai ta sẽ cùng mở rộng trái tim\n" +
                "Và cùng cho nhau\n" +
                "Yêu lại từ đầu"))
    }
}