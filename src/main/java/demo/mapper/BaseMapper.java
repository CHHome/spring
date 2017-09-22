package demo.mapper;

import java.util.List;

public interface BaseMapper<T> {
	/**
	 * ����������ѯ��¼
	 * @param id ����ID
	 * @return ��ѯ�ļ�¼����װ��һ��������
	 */
	T findById(int id);
	/**
	 * ��ѯ���м�¼
	 * @return ���м�¼���б����
	 */
	List<T> find();
	/**
	 * ��ҳ��ѯ
	 * @param pageIndex ��ѯ����ʼ����λ��
	 * @param pageSize ��ѯ�ļ�¼������
	 * @return ��ѯ�ļ�¼�б����
	 */
	List<T> findByPage(int pageIndex, int pageSize, T t);
	/**
	 * ����һ������
	 * @param t ����Ķ���
	 */
	void save(T t);
	/**
	 * ������������ɾ��
	 * @param id ɾ��������
	 */
	void delete(int id);
	/**
	 * ����һ������
	 * @param t ���µĶ���
	 */
	void update(T t);
	/**
	 * ͳ�Ƶ�ǰ�ı�ļ�¼����
	 * @return ��¼����
	 */
	Long count(T t);
}
