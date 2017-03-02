package org.hbgb.webcamp.client.widget;

import java.util.EnumSet;

import com.google.gwt.user.client.ui.ListBox;

/**
 * A {@link ListBox} that contains values of an enum. Clients can override
 * {@link #toLabel} to display text other than the string value of the enum in
 * the box.
 */
public class EnumListBox<E extends Enum<E>> extends ListBox
{
	protected Class<E> _eclass;

	/**
	 * Creates an enum list box that displays all values in the supplied enum.
	 */
	public EnumListBox(Class<E> eclass)
	{
		this(eclass, EnumSet.allOf(eclass));
	}

	/**
	 * Creates an enum list box that displays the values in the supplied set.
	 */
	public EnumListBox(Class<E> eclass, EnumSet<E> elements)
	{
		_eclass = eclass;

		addItem("Choose One");

		for (E value : elements)
		{
			addItem(toLabel(value), value.toString());
		}
	}

	/**
	 * Selects the specified value.
	 */
	public void setSelectedValue(E value)
	{
		if (null == value)
		{
			setSelectedIndex(0);
		}
		else
		{
			String valstr = value.toString();
			for (int i = 0; i < getItemCount(); i++)
			{
				if (getValue(i).equals(valstr))
				{
					setSelectedIndex(i);
					break;
				}
			}
		}
	}

	/**
	 * Returns the currently selected value, or null if no value is selected.
	 */
	public E getSelectedEnumValue()
	{
		int selidx = getSelectedIndex();
		return (selidx == 0) ? null : Enum.valueOf(_eclass, getValue(selidx));
	}

	/**
	 * Returns a string that will be shown to the user for the specified enum.
	 */
	protected String toLabel(E value)
	{
		return value.toString();
	}

}
