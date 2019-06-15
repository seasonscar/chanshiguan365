@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MultiThreadConfig.class })
public class MultiThreadTest {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private MultiThreadProcessService multiThreadProcessService;

    @Test
    public void test() {

        int n = 20;
        for (int i = 0; i < n; i++) {
            taskExecutor.execute(new MultiThreadDemo(multiThreadProcessService));
            System.out.println("int i is " + i + ", now threadpool active threads totalnum is " + taskExecutor.getActiveCount());
        }

        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}