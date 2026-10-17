// @ts-check
import { defineConfig } from 'astro/config';
import starlight from '@astrojs/starlight';


// https://astro.build/config
export default defineConfig({
	integrations: [
		starlight({
      title: 'Kore',
			defaultLocale :'en',
			social: [{ icon: 'github', label: 'GitHub', href: 'https://github.com/dev778g-me/Kore' }],
      customCss: [
       './src/custom.css',
      ],
      head: [
        {
          tag: 'link',
          attrs: {
            rel: 'preload',
            href: '/fonts/google-sans-flex-latin.woff2',
            as: 'font',
            type: 'font/woff2',
            crossorigin: 'anonymous',
          },
        },
        {
          tag: 'link',
          attrs: {
            rel: 'preload',
            href: '/fonts/google-sans-flex-latin-ext.woff2',
            as: 'font',
            type: 'font/woff2',
            crossorigin: 'anonymous',
          },
        },
      ],
      components: {
        Sidebar: './src/components/DocsSidebar.astro',
        ThemeSelect: './src/components/ThemeToggle.astro',
        SocialIcons: './src/components/SocialIcons.astro',
      },
      sidebar: [
				{ label: 'Create', link: '/create/' },
				{
					label: 'Getting Started',
					items: [
						{ label: 'Overview', slug: 'getting-started/overview' },
						{ label: 'Installation', slug: 'getting-started/installation' },
						{ label: 'Quickstart', slug: 'getting-started/quickstart' },
					],
				},
				{
					label: 'Components',
					items: [
						{
							label: 'Inputs & Controls',
							items: [
								{ label: 'Buttons', slug: 'components/buttons' },
								{ label: 'Icon Buttons', slug: 'components/icon-buttons' },
								{ label: 'Checkbox', slug: 'components/checkbox' },
								{ label: 'Dropdown', slug: 'components/dropdown' },
								{ label: 'Radio Button', slug: 'components/radio-button' },
								{ label: 'Switch', slug: 'components/switch' },
								{ label: 'Slider', slug: 'components/slider' },
								{ label: 'Text Field', slug: 'components/text-field' },
							],
						},
						{
							label: 'Feedback & Indicators',
							items: [
								{ label: 'Badge', slug: 'components/badge' },
								{ label: 'Dialog', slug: 'components/dialog' },
								{ label: 'Loading Indicator', slug: 'components/loading-indicator' },
								{ label: 'Progress Indicator', slug: 'components/progress-indicator' },
							],
						},
						{
							label: 'Data Display',
							items: [
								{ label: 'Accordion', slug: 'components/accordion' },
								{ label: 'Card', slug: 'components/card' },
								{ label: 'ListTile', slug: 'components/list-tile' },
								{ label: 'Stepper', slug: 'components/stepper' },
							],
						},
						{
							label: 'Navigation',
							items: [
								{ label: 'Appbar', slug: 'components/appbar' },
								{ label: 'Navigation Bar', slug: 'components/navigation-bar' },
							],
						},
						{
							label: 'Foundation',
							items: [
								{ label: 'Separators', slug: 'components/separator' },
								{ label: 'Stack', slug: 'components/stack' },
							],
						},
						{
							label: 'Extensions',
							items: [
								{ label: 'Colors', slug: 'components/colors' },
								{ label: 'Modifiers', slug: 'components/modifiers' },
								{ label: 'Typography', slug: 'components/typography' },
							],
						},
					],
				},

			],
		}),
	],
});
