package stk.web.gae.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Key;

/**
 * イメージデータのテストケース
 * @author keisuke.oohashi
 *
 */
public class ImageTest extends AppEngineTestCase {

	private Image model = new Image();

	@Test
	public void test() throws Exception {
		assertThat(model, is(notNullValue()));
	}

	@Test
	public void test_正常_プットできるか() {
		Key key = Datastore.allocateId(Image.class);
		model.setKey(key);
		model.setTitle("title");
		Datastore.put(model);
		assertThat(model, is(Datastore.get(Image.class,key)));
	}

	@Test
	public void test_正常_Memberモデルへのリレーション(){
		Key key = Datastore.allocateId(Image.class);
		model.setKey(key);
		Member member = new Member();
		model.getUpdaterRef().setModel(member);
		Datastore.put(model,member);
		assertThat(member , is(Datastore.get(Image.class , key).getUpdaterRef().getModel()));
	}

	@Test
	public void test_正常_ImgUnitモデルへのリレーション(){
		Key key = Datastore.allocateId(Image.class);
		model.setKey(key);
		ImgUnit imgUnit = new ImgUnit();
		imgUnit.setSort(1);
		ImgUnit imgUnit2 = new ImgUnit();
		imgUnit2.setSort(2);
		imgUnit.getImageRef().setModel(model);
		imgUnit2.getImageRef().setModel(model);
		Datastore.put(model , imgUnit , imgUnit2);
		assertThat(model, is(Datastore.get(Image.class,key)));
		assertThat(2, is(Datastore.get(Image.class,key).getImgUnitListRef().getModelList().size()));
		assertThat(imgUnit, is(Datastore.get(Image.class , key).getImgUnitListRef().getModelList().get(0)));
		assertThat(imgUnit2, is(Datastore.get(Image.class , key).getImgUnitListRef().getModelList().get(1)));
	}

	@Test
	public void test_正常_バイトデータを保存できるか(){
		List<ImgUnit> imgUnitList = model.setImage("testdata".getBytes());
		List<Key> keys = Datastore.put(imgUnitList);
		Key key = Datastore.put(model);
		assertThat(model.getImage() , is(Datastore.get(Image.class,key).getImage()));
		assertThat("testdata" , is(new String(Datastore.get(Image.class , key).getImage())));
	}

}
