// @ts-check
import { defineConfig } from 'astro/config';
import starlight from '@astrojs/starlight';
import '@fontsource-variable/google-sans-flex';


// https://astro.build/config
export default defineConfig({
	integrations: [
		starlight({
      title: 'Kore',
			defaultLocale :'en',
			social: [{ icon: 'github', label: 'GitHub', href: 'https://github.com/dev778g-me/Kore' }],
      customCss: [
       './src/custom.css'
      ],
      components: {
        Sidebar: './src/components/DocsSidebar.astro',
        ThemeSelect: './src/components/ThemeToggle.astro',
      },
      sidebar: [
				{
					label: 'Guides',
					items: [
						// Each item here is one entry in the navigation menu.
						{ label: 'Example Guide', slug: 'guides/example' },
					],
				},
				{
					label: 'Reference',
					items: [{ autogenerate: { directory: 'reference' } }],
				},
			],
		}),
	],
});
