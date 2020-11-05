package com.example.destinybynumbers.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.destinybynumbers.DestinyApplication
import java.util.concurrent.Executors

@Database(entities = [PythagoreanTable::class,
    DestinyDefinitions::class,
    InquiryResults::class],
    version = 1)
abstract class DestinyDB : RoomDatabase() {

    abstract fun getDao(): DestinyDao

    companion object {
        @Volatile
        private var INSTANCE: DestinyDB? = null

        fun createInstance(): DestinyDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
                synchronized(this) {
                        val instance = Room.databaseBuilder(
                            DestinyApplication.destinyApplication!!,
                            DestinyDB::class.java,
                            "destiny_db"
                        ).build()
                        INSTANCE = instance
                        return instance
                }
        }

        private fun buildPythagoreanTable(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            DestinyDB::class.java, "pythagorean_table")
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        ioThread {
                            createInstance().getDao().populatePythagorean(PREPOPULATE_PYTHAGOREAN_DATA)
                        }
                    }
                }).build()

        private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

        fun ioThread(f : () -> Unit) {
            IO_EXECUTOR.execute(f)
        }

        val PREPOPULATE_PYTHAGOREAN_DATA = listOf(
            PythagoreanTable(1, "AJS"),
            PythagoreanTable(2, "BKT"),
            PythagoreanTable(3, "CLU"),
            PythagoreanTable(4, "DMV"),
            PythagoreanTable(5, "ENW"),
            PythagoreanTable(6, "FOX"),
            PythagoreanTable(7, "GPY"),
            PythagoreanTable(8, "HQZ"),
            PythagoreanTable(9, "IR"))

        private fun buildDestinyDefinitionsTable(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                DestinyDB::class.java, "destiny_definitions")
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        ioThread {
                            createInstance().getDao().populateDestiny(PREPOPULATE_DESTINY_DATA)
                        }
                    }
                }).build()

        val PREPOPULATE_DESTINY_DATA = listOf(
            DestinyDefinitions("1",
                "You are a true innovator. You have an eye for spotting " +
                        "the next big thing on the horizon and know how to turn any " +
                        "dream into a reatity.",
                "You have the potential for extreme growth in this " +
                        "lifetime. You can feel restless when it comes to employment," +
                        " relationships and home life. If you can learn to appreciate " +
                        "the present moment when these feelings arise those feelings " +
                        "will pass.",
                "You prefer to be in control of all aspects of life",
                "You are brilliant. Ones unite both male and female " +
                        "tendencies into a natural balance that is magnetic and " +
                        "attractive.",
                "Innovative",
                "Protective"),
            DestinyDefinitions("2",
                "Your purpose is to be someone who blazes trails, but with " +
                        "a gentle flame that warms but never burns. You are a visionary.",
                "You have a very strong connection to your home.  You thrive on a " +
                        "sense of security and all being well and happy on the home front.",
                "You need harmony, symmetry and balance and enjoy working on a team.",
                "You are very intuitive with a finely tuned sense of empathy.",
                "Counseling and Protective",
                "Compassionate"),
            DestinyDefinitions("3",
                "You take joy in living life to the " +
                    "fullest. Because of your positive outlook on life you are perceived" +
                    " by others as charming and charasmatic.",
                "You are open, loyal and naive at times. Because you are" +
                        " so open to others your odds of getting hurt are increased." +
                        " Stay open but be cautious, a little self-protections is a " +
                        "good quality to have.",
                "You have a genuinely good spirit and your energy and " +
                        "enthusiasm about life is contagious.",
                "You are a great balancer among your friends and coworkers.",
                "Friendly and Charismatic",
                "Social"),
            DestinyDefinitions("4",
                "Success is in the cards for you, it's unavoidable. Your" +
                        " determination and work ethic will serve you well. Try " +
                        "not to work too hard, a little fun is good for the soul.",
                "You choose quality over quantity every time. In " +
                        "relationships, if those you surround yourself with don't " +
                        "measure up, you will not keep them around.",
                "Your main life lesson is to learn how to satisfy your " +
                        "inner need for stability, structure and security while " +
                        "at the same time learning not to impose this on others " +
                        "who do not live their lives the same way.",
                "You are a go getter.  You know that slow and steady " +
                        "wins the race, and you are not going to risk your chances " +
                        "at success by being lazy.",
                "Successful",
                "Integrity"),
            DestinyDefinitions("5",
                "You live your life to the extreme and in full color. " +
                        "Life is never just black and white or for, for that " +
                        "matter, grey. You are a thrill seeker who hates boredom" +
                        " and you will go to great lengths to find things that " +
                        "interest you.",
                "You can do anything you put your mind to so you should " +
                        "focus on your passions. Jus be sure to stay focused so " +
                        "things don't slip away while you are distracted.",
                "You crave freedom and are drawn to travel and new experiences." +
                        " You are not shy or awkward and you adapt to new situations with" +
                        " ease.",
                "You like balance and harmony. People consider you the " +
                        "peacemaker and you are a natural born mediator. You are a great ally" +
                        " because you are balanced and truthful.",
                "Adventurous and Adaptable",
                "Social and Fun"),
            DestinyDefinitions("6",
                "You have strong domestic ties. What happens in your " +
                        "own home is your #1 priority. You will sacrifice nearly " +
                        "anything to make sure those you love and care about " +
                        "are protected, loved and nurtured.",
                "You feel strongly connected to everything spiritual." +
                        " You believe in the greater good and feel connected to " +
                        "universal energies.",
                "You crave stability and security. You do not react well " +
                        "when either of those things is compromised. Your loving " +
                        "and generous nature quickly shift to one that is controlling" +
                        " and intrusive in an attempt to regain the harmony and " +
                        "balance you require.",
                "You are nurturing, emotional, protective and healing." +
                        " You are the first one to show up when someone is in need" +
                        " and you will continue to give of yourself for as long " +
                        "as necessary.",
                "Healing and Giving",
                "Nurturing"),
            DestinyDefinitions("7",
                "You are a unique thinker and visionary. You are unyielding" +
                        " You must always understand 'why' something is as it is" +
                        " and always strive for perfection.",
                "You are very intuitive and have a strong connection to" +
                        " the divine. You regularly receive guidance from your higher" +
                        " self through dreams, psychic readings, etc. You have a very" +
                        " open mind which makes you perceptive to influential " +
                        "energies. This gives you a truly visionaly vibe that " +
                        "is apparent to others.",
                "The major lesson of your life  is to learn how to balance" +
                        " your need for solitude and self-discovery with being an" +
                        " active member of society. For you, a little isolation is " +
                        "necessary. Just be mindful of when it's time to come back " +
                        "and join the rest of us.",
                "You are a natural born observer. You will frequently " +
                        "sit by watching the interactions of others which you find" +
                        " fascinating.  You are the consummate 'people watcher'.",
                "Visionary",
                "Unique"),
            DestinyDefinitions("8",
                "You are a go-getter. Sometimes your energy alone is " +
                        "enough to get things done. The words 'fail' and 'not possible'" +
                        " are not in your vocabulary and your confidence is contagious.",
                "You often feel the pull of separate but equal energies of " +
                        "the positive and negative sides of success. Your life seems " +
                        "charmed but you will have occasional struggles and setbacks." +
                        " If you are not prepared this can be quite devastating to you.",
                "You strive for recognition and are capable of acheiving great " +
                        "things. You want to be remembered for your greatness. While " +
                        "this is well desserved, it is important for you to remember " +
                        "that you are not alone in the world and others desserve " +
                        "recognition as well.",
                "You have an unyielding drive and like to be in control. " +
                        "Learning to harness these energies will help you to control " +
                        "the direction of your life path in a positive way.",
                "Forward Thinking",
                "Goal Oriented"),
            DestinyDefinitions("9",
                "You are like a calm reprieve after a violent storm. You emit" +
                        " a certain energy that makes others feel as though everything " +
                        "will be OK. You are a pillar of strength and dependability. " +
                        "You have not only learned the lessons but how to apply them in " +
                        "life. You think before you act and act with the greater good " +
                        "in mind.",
                "You look for completion and positive outcomes in life. You " +
                        "are intuitive and empathetic. You enjoy participating in " +
                        "humanitarian activities. Although you do not desire praise, " +
                        "you always appreciate being recognized.",
                "You have a genuine spirit. Because most people are rarely as" +
                        " truly caring and genuine as you are, people may be " +
                        "suspicious of you at times. Following career and hobby paths" +
                        " that are service oriented will be very rewarding to you.",
                "You are a gentle and mature soul. You value success but " +
                        "not in monetary terms. You place a high value on morals and " +
                        "expect those closest to you to do the same.",
                "Reliable and Honest",
                "Compassionate"),
            DestinyDefinitions("11",
                "Master Number 11 has an underlying theme which is " +
                        "enlightenment and universal connection",
                "You are attracted to spirituality and metaphysics. For " +
                        "you this isn't a curiosity, but an inner drive.",
                "You believe in the connection between the physical and " +
                        "spiritual worlds and understanding and respecting that " +
                        "connection is important to you.",
                "You have a free flowing and inquisitive nature. When in" +
                        " balance you are spiritual, gifted, honest, straightforward, " +
                        "objective and fair. When you are not balanced you can become " +
                        "moody, cynical, unyielding and harsh. This is not a criticism," +
                        " just something to guard against.",
                "Spiritual",
                "Inner Guidance"),
            DestinyDefinitions("22",
                "You are one who turns dreams and ideas into reality. You take " +
                        "knowledge and apply it to the life around you. ",
                "Your journey is one of pragmatism, practicality and ambition. " +
                        "While living this way you still manage to maintain your " +
                        "connection to the intuitive energies around you.",
                "You can take something that is ethereal and make it concrete. " +
                        "You are, in your own way, able to materialize the connection " +
                        "between the spiritual and physical world.",
                "You have equally strong energies of light and dark. You can " +
                        "be both creative and destructive and that opposition can throw " +
                        "people off guard. When sad you can tend to be self destructive " +
                        "and when you feel this way a good outlet would be exercise or " +
                        "meditation.",
                "Innovative",
                "Transformation"),
            DestinyDefinitions("33",
                "Thirty-Three is the number of mastery , completion and self-" +
                        "realization. You are knowledgeable and are frequently seen as " +
                        "wise beyond your years. ",
                "You are here to help people with their knowledge and enlightenment." +
                        " You have a great deal to share with the world.",
                "You have experienced deep spiritual seeking as well as dedicated" +
                        " servitude and creation.",
                "You are always ready to lend a helping hand when needed. Your" +
                        "  true gifts however, are your ability to see through any situation " +
                        "and get to the crux of the matter. You are a very good listener " +
                        "and people come to you for advice or use you as a sounding board.",
                "Knowledgeable and Wise",
                "Complete Mastery")
        )

    }
}